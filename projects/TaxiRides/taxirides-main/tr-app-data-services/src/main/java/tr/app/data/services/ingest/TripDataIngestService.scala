package tr.app.data.services.ingest


trait TripDataIngestService {

  def execute(tripDataIngestConfig: IngestTripDataConfig): String

}

object TripDataIngestService {

  val SERVICE_LOOKUP_NAME: String = "TripDataIngestService"
}