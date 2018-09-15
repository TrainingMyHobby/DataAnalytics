package tr.app.data.services.ingest

import tr.app.common.dto.ingest._

trait TripDataIngestService {

  def execute(ingestConf: IngestTripDataConfig): String

}

object TripDataIngestService {

  val SERVICE_LOOKUP_NAME: String = "TripDataIngestService"
}