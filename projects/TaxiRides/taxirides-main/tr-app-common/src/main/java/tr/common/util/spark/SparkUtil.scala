package tr.common.util.spark

//import org.apache.spark.SparkConf
//import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import tr.common.dto.ingest.IngestTripDataConfig

object SparkUtil {

  def initializeSparkContext(ingestConfig: IngestTripDataConfig): SparkSession = {

    var sparkSessionBuilder = SparkSession.builder
      .appName(ingestConfig.getIngestConfig().getIngestApplicationName())
      .master(ingestConfig.getIngestSparkConfig().getSparkMaster())
      .enableHiveSupport()

    sparkSessionBuilder = sparkSessionBuilder.config("spark.sql.warehouse.dir", "/tmp/target/spark-warehouse")

    val sparkSession = sparkSessionBuilder.getOrCreate()
    sparkSession
  }

}