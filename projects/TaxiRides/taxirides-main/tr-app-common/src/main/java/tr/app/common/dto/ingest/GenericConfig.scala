package tr.app.common.dto.ingest

import tr.app.common.dto.DynamicDTO

trait GenericConfig extends DynamicDTO {

  private var _globalConfig: String = _
  private var _ingestConfig: String = _

  def getGlobalConfig = _globalConfig

  def setGlobalConfig(value: String): Unit = _globalConfig = value

  def getIngestConfig = _ingestConfig

  def setIngestConfig(value: String): Unit = _ingestConfig = value

}