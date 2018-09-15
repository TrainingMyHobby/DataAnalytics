package tr.app.data.ingest.src2raw.spark

import tr.app.common.dto.ingest.IngestTripDataConfig
import tr.app.data.services.ingest.IngestObjectFactory
import tr.app.common.constants.IngestConstants

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

