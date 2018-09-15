package tr.common.dto

class CtxData extends DynamicDTO {

  var dataObjs = Map.empty[String, Object]

  def putCtxObj(key: String, value: Object): Unit = dataObjs += key -> value

  def getCtxObj(key: String): Object = {
    dataObjs get key getOrElse null
  }

  def removeCtxObj(key: String): Unit = dataObjs -= key

  def containsCtxObj(key: String) = dataObjs.contains(key)

}