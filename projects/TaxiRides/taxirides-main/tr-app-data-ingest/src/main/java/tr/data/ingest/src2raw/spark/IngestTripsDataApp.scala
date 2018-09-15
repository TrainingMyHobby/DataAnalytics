package tr.data.ingest.src2raw.spark

import tr.common.dto.GlobalConfig
import tr.data.services.ingest.IngestObjectFactory
import tr.common.constants.IngestConstants
import tr.common.dto.ingest.IngestTripDataConfig
import org.slf4j.LoggerFactory

object IngestTripsDataApp {

  private val LOGGER = LoggerFactory.getLogger("IngestTripsDataApp")

  def main(args: Array[String]) {
    LOGGER.info("Enter")

    val globalConfigFilePath = args(0)
    val ingestConfigFilePath = args(1)

    LOGGER.info("globalConfigFilePath " + globalConfigFilePath + " ingestConfigFilePath " + ingestConfigFilePath)

    val globalConfig = new GlobalConfig(globalConfigFilePath)
    globalConfig.initializeGlobalConfigs()

    val tripDataIngestConfig = new IngestTripDataConfig(ingestConfigFilePath)
    tripDataIngestConfig.initializeIngestConfigs()

    IngestObjectFactory.getTripDataIngestService(IngestConstants.EXEC_ENGINE_SPARK).execute(tripDataIngestConfig)

    LOGGER.info("Exit")
  }

}

