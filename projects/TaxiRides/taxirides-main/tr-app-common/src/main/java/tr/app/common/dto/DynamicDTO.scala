package tr.app.common.dto

import scala.language.dynamics

trait DynamicDTO extends Dynamic {

  private var members = Map.empty[String, Object]

  def selectDynamic(name: String) = {
    members get name getOrElse sys.error("Method not initialized yet")
  }

  def updateDynamic(name: String)(value: Object) {
    members += name -> value
  }

}