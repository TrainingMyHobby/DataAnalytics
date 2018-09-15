package tr.common.dto

import org.apache.spark.sql.SparkSession

class SparkCtxData(sparkSession: SparkSession) extends CtxData {

  def getSparkSession() = sparkSession

}