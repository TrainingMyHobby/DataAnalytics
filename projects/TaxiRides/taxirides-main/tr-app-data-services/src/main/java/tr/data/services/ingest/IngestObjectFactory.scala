package tr.data.services.ingest

import tr.data.services.ingest.impl.TripDataIngestServiceSparkImpl
import tr.common.constants.IngestConstants

object IngestObjectFactory {

  var objects = scala.collection.mutable.Map[String, scala.collection.mutable.Map[String, Object]]()

  var tripDataServiceEngineImpls = scala.collection.mutable.Map[String, Object]()
  tripDataServiceEngineImpls += IngestConstants.EXEC_ENGINE_SPARK -> new TripDataIngestServiceSparkImpl()

  objects += TripDataIngestService.SERVICE_LOOKUP_NAME -> tripDataServiceEngineImpls

  def getTripDataIngestService(execEngine: String): TripDataIngestService = {
    val execEnginesMap = objects get TripDataIngestService.SERVICE_LOOKUP_NAME
    val serviceImpl = execEnginesMap get execEngine
    serviceImpl.asInstanceOf[TripDataIngestService]
  }

}