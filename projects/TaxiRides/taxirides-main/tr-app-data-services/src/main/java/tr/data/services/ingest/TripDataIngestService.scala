package tr.data.services.ingest

import tr.common.dto.ingest.IngestTripDataConfig
import tr.common.service.AppService

trait TripDataIngestService extends AppService {

  def execute(a:IngestTripDataConfig): String

}

object TripDataIngestService {

  val SERVICE_LOOKUP_NAME: String = "TripDataIngestService"
}