
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alexgalays/Documents/workspace/alex/poc-http-aggregation/conf/routes
// @DATE:Tue Aug 15 12:27:37 CEST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  ApiAggregation_1: controllers.ApiAggregation,
  // @LINE:4
  Application_0: controllers.Application,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    ApiAggregation_1: controllers.ApiAggregation,
    // @LINE:4
    Application_0: controllers.Application
  ) = this(errorHandler, ApiAggregation_1, Application_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ApiAggregation_1, Application_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/aggregation/""" + "$" + """mainResourceUrl<[^/]+>""", """controllers.ApiAggregation.index(mainResourceUrl:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """any<.*>""", """controllers.Application.index(any:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_ApiAggregation_index0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/aggregation/"), DynamicPart("mainResourceUrl", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ApiAggregation_index0_invoker = createInvoker(
    ApiAggregation_1.index(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiAggregation",
      "index",
      Seq(classOf[String]),
      "POST",
      this.prefix + """api/aggregation/""" + "$" + """mainResourceUrl<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_Application_index1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("any", """.*""",false)))
  )
  private[this] lazy val controllers_Application_index1_invoker = createInvoker(
    Application_0.index(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Seq(classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """any<.*>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_ApiAggregation_index0_route(params) =>
      call(params.fromPath[String]("mainResourceUrl", None)) { (mainResourceUrl) =>
        controllers_ApiAggregation_index0_invoker.call(ApiAggregation_1.index(mainResourceUrl))
      }
  
    // @LINE:4
    case controllers_Application_index1_route(params) =>
      call(params.fromPath[String]("any", None)) { (any) =>
        controllers_Application_index1_invoker.call(Application_0.index(any))
      }
  }
}
