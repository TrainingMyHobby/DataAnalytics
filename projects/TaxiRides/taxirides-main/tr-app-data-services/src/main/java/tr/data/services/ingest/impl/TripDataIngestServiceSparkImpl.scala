package tr.data.services.ingest.impl

import tr.common.dto.ingest.IngestTripDataConfig
import tr.common.util.spark.SparkUtil
import tr.data.services.ingest.TripDataIngestService

class TripDataIngestServiceSparkImpl extends TripDataIngestService {

  def execute(a: IngestTripDataConfig): String = {

    val sparkSession = SparkUtil.initializeSparkContext()

    null
  }

}