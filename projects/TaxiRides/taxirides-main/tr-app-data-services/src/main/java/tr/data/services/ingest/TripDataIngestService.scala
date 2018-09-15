package tr.data.services.ingest

import tr.common.dto.ingest.IngestTripDataConfig

trait TripDataIngestService {

  def execute(a:IngestTripDataConfig): String

}

object TripDataIngestService {

  val SERVICE_LOOKUP_NAME: String = "TripDataIngestService"
}