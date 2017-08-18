package controllers

import scala.concurrent.{Future, ExecutionContext}
import scala.util.Try

import play.api._
import play.api.mvc.{Results, AbstractController, ControllerComponents}
import play.api.libs.ws._
import play.api.libs.json.{JsValue, JsObject, JsArray, JsString, Json, Reads, JsSuccess}

import cats.data.EitherT
import cats.instances.future._


class ApiAggregation(cc: ControllerComponents, ws: WSClient)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def index(mainResourceUrl: String) = Action.async(parseQuery) { request =>

    aggregateFromUrl(mainResourceUrl, request.body).map {
      case Right(value)                       => Ok(value)
      case Left(InvalidUrl(url))              => BadRequest(s"Invalid url: $url")
      case Left(HttpError(url, status))       => InternalServerError(s"Got a $status error on GET $url")
      case Left(UnsupportedTopLevelJSON(url)) => InternalServerError(s"Only top level object JSON is supported; got an Array from $url")
      case Left(NetworkError(url))            => InternalServerError(s"Could not reach $url")
    }
  }

  private def aggregateFromUrl(url: String, nodes: List[Node]): Future[Either[AggregationError, JsObject]] = {
    (for {
      json   <- EitherT(safeHttpGet(url))
      result <- EitherT(extractFromNodes(json, nodes))
    } yield result).value
  }

  private def safeHttpGet(url: String): Future[Either[AggregationError, JsObject]] = {

    Try(new java.net.URL(url)).fold(
      err => Future.successful(Left(InvalidUrl(url))),
      ok  => ws.url(url).get().map(res =>
        if (res.status < 200 || res.status >= 300) Left(HttpError(url, res.status))
        else res.json match {
          case obj: JsObject => Right(obj)
          case _ => Left(UnsupportedTopLevelJSON(url))
        }
      )
      .recover { case err => Left(NetworkError(url)) }
    )
  }

  private def extractFromNodes(obj: JsObject, nodes: List[Node]): Future[Either[AggregationError, JsObject]] = {

    val futureMerges = Future.sequence(nodes.map(node => {
      (obj \ node.field).asOpt[JsValue] match {
        // Ignore missing field; could be a typo but also could be an optional field; it should be validated on the client either way.
        case None => Future.successful(Right(Json.obj()))

        // It's a string, but the node has children: It must therefore be an URL.
        case Some(JsString(str)) if node.children.nonEmpty => (for {
          objFromUrl <- EitherT(aggregateFromUrl(str + node.query.fold("")("?" + _), node.children))
          mergePiece <- EitherT.pure[Future, AggregationError](Json.obj(node.field -> objFromUrl))
        } yield mergePiece).value

        // An object with some child nodes defined: continue filtering down
        case Some(o: JsObject) if node.children.nonEmpty => extractFromNodes(o, node.children)
          .map(_.map(deepObject => Json.obj(node.field -> deepObject)))

        // An Array with some child nodes defined: continue filtering down for each element
        case Some(JsArray(arr)) if node.children.nonEmpty =>
          val objs = arr.collect { case o: JsObject => o }
          Future.sequence(objs.map(el => extractFromNodes(el, node.children)))
            .map(sequence(_).map(pieces => Json.obj(node.field -> JsArray(pieces))))

        // Flat String, Number, Boolean, Object, Array: copied as-is
        case Some(v: JsValue) => Future.successful(Right(Json.obj(node.field -> v)))
      }
    }))

    futureMerges.map(sequence(_).map(_.reduce(_ ++ _)))
  }

  val parseQuery = parse.text.map(text => {
    val defaultIndendation = text.dropWhile(_ == '\n').takeWhile(c => c == ' ').size
    val fields = text.split('\n').dropWhile(_ == '\n').toList

    def indentationOf(text: String) =
      text.takeWhile(_ == ' ').size

    def processNode(text: List[String], indentation: Int): List[Node] = {
      val indexes = text.zipWithIndex.collect {
        case (field, i) if indentationOf(field) == indentation => i }

      indexes.map { index =>
        val field = text(index).trim
        val children = text.drop(index + 1).takeWhile(indentationOf(_) != indentation)
        Node(field, processNode(children, indentation + 2))
      }
    }

    processNode(fields, defaultIndendation)
  })

  private def sequence[A, B](s: Seq[Either[A, B]]): Either[A, Seq[B]] =
    s.foldRight(Right(Nil): Either[A, List[B]]) {
      (e, acc) => for (xs <- acc; x <- e) yield x :: xs
    }

  sealed trait AggregationError
  case class InvalidUrl(url: String) extends AggregationError
  case class NetworkError(url: String) extends AggregationError
  case class HttpError(url: String, status: Int) extends AggregationError
  case class UnsupportedTopLevelJSON(url: String) extends AggregationError

  case class Node(rawField: String, children: List[Node]) {
    lazy val (field, query) = {
      val list = rawField.split('?')
      (list.lift(0).getOrElse(""), list.lift(1))
    }
  }
}
