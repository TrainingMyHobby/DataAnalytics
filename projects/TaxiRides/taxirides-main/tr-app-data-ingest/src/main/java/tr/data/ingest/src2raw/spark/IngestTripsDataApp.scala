package tr.data.ingest.src2raw.spark

import tr.common.dto.ingest.IngestTripDataConfig
import tr.data.services.ingest.IngestObjectFactory
import tr.common.constants.IngestConstants

object IngestTripsDataApp {

  def main(args: Array[String]) {

    val globalConfig = "" //args(0)
    val ingestConfig = "" // args(1)

    val tripDataIngestConfig = new IngestTripDataConfig()
    tripDataIngestConfig.globalConfig = globalConfig
    tripDataIngestConfig.ingestConfig = ingestConfig

    IngestObjectFactory.getTripDataIngestService(IngestConstants.EXEC_ENGINE_SPARK).execute(tripDataIngestConfig)

  }

}

