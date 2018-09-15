package tr.common.dto.ingest

import com.typesafe.config.ConfigFactory
import tr.common.dto.SparkConfig
import java.nio.file.Paths

class IngestTripDataConfig(_ingestConfigFilePath: String) {

  private var _ingestConf: IngestConfig = _
  private var _ingestSparkConfig: SparkConfig = _

  def initializeIngestConfigs() {

    val confFile = Paths.get(_ingestConfigFilePath).toFile
    val config = ConfigFactory.parseFile(confFile)

    _ingestConf = new IngestConfig(config)
    _ingestSparkConfig = new SparkConfig(_ingestConf.getConfig().atPath("taxirides-app.tr-data-ingest.spark-config"))
  }

  def getIngestConfig() = _ingestConf

  def getIngestSparkConfig() = _ingestSparkConfig

}