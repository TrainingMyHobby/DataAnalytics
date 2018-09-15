package tr.app.data.services.ingest

import tr.app.common.dto.ingest.IngestTripDataConfig


trait TripDataIngestService {

  def execute(tripDataIngestConfig: IngestTripDataConfig): String

}

object TripDataIngestService {

  val SERVICE_LOOKUP_NAME: String = "TripDataIngestService"
}