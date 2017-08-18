package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.{JsValue, Json}


class Application(cc: ControllerComponents) extends AbstractController(cc) {

  def index(path: String) = Action {
    Ok(views.html.index())
  }

}
