package tr.common.dto.ingest

import com.typesafe.config.Config

class IngestConfig(_ingestConfig: Config) {

  def getConfig() = _ingestConfig

  def getDataIngestNodeConfig() = _ingestConfig.getConfig("taxirides-app.tr-data-ingest")

  def getApplicationNodeConfig() = {
    println(_ingestConfig)
    getDataIngestNodeConfig.getConfig("application")
  }

  def getIngestApplicationName() = getApplicationNodeConfig.getString("name")

}