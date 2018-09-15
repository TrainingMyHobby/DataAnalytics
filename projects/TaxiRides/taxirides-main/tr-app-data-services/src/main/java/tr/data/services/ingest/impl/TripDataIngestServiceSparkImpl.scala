package tr.data.services.ingest.impl

import tr.common.dto.SparkCtxData
import tr.common.dto.ingest.IngestTripDataConfig
import tr.common.util.spark.SparkUtil
import tr.data.services.ingest.TripDataIngestService
import org.apache.spark.rdd.RDD
import java.nio.file.Paths
import java.net.URI

class TripDataIngestServiceSparkImpl extends TripDataIngestService with java.io.Serializable {

  def execute(ingestConfig: IngestTripDataConfig): String = {

    val sparkSession = SparkUtil.initializeSparkContext(ingestConfig)
    val ctxData = new SparkCtxData(sparkSession)

    val noOfInputDataNodes = ingestConfig.getIngestConfig().getNoOfInputDataNodes

    for (dataNodeIndexNo <- 1 to noOfInputDataNodes) {
      performIngestForADataNode(dataNodeIndexNo, ctxData, ingestConfig)
    }

    null
  }

  private def performIngestForADataNode(dataNodeIndexNo: Int, ctxData: SparkCtxData, ingestConfig: IngestTripDataConfig): Unit = {

    val inputFileLocations = ingestConfig.getIngestConfig().getLocationsForAnInputDataNode(dataNodeIndexNo)
    val ingestConcurrency = ingestConfig.getIngestConfig().getConcurrencyForAnInputDataNode(dataNodeIndexNo)

    val inputFilesRDD = ctxData.getSparkSession().sparkContext.parallelize(inputFileLocations, ingestConcurrency)

    inputFilesRDD.foreachPartition(performIngestForAPartition)

  }

  private def performIngestForAPartition(rddpartition: Iterator[Object]): Unit = {

    rddpartition.foreach(tripDataFileLocation => ingestATripDataFile(tripDataFileLocation.asInstanceOf[String]))

  }

  private def ingestATripDataFile(tripDataFileLocation: String) {
    println("tripDataFileLocation " + tripDataFileLocation)
    var (year, month, filename) = extractYearAndMonthFromFileName(tripDataFileLocation)
  }

  private def extractYearAndMonthFromFileName(tripDataFileLocation: String): (String, String, String) = {

    val filename = Paths.get(new URI(tripDataFileLocation).getPath()).getFileName().toString()
    val yearAndMonthList = ("""\d+""".r findAllIn filename).toList

    (yearAndMonthList(0).toString, yearAndMonthList(1).toString, filename)
  }

}