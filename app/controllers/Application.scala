package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index.render)
  }
  
  def koan1 = Action { request =>
    val params: Map[String, Seq[String]] = request.body.asFormUrlEncoded.getOrElse[Map[String, Seq[String]]] { Map.empty }

    println(views.html.koans.koanset1.koan1(getParam(params, "koan1"))(true))
    
    Ok(views.html.koans.koan1.render(getParam(params, "koan1"), getParam(params, "koan2"), (false)))
    
  }
  
  def getParam(params: Map[String, Seq[String]], name: String): Option[String] = {
    params.get(name).map { values: Seq[String] =>
      values.head
    }.orElse {
      None
    }
  }
  
}