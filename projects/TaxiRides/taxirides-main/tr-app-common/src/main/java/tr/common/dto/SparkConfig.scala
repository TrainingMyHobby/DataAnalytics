package tr.common.dto

import com.typesafe.config.Config

class SparkConfig(conf: Config) {

  def getSparkMaster() = "local[*]"

}