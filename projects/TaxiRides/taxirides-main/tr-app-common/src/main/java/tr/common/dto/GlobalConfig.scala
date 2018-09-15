package tr.common.dto

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import java.nio.file.Paths

class GlobalConfig(_globalConfigFilePath: String) extends DynamicDTO {

  protected var _globalConf: Config = _
  protected var _globalSparkConfig: SparkConfig = _

  def getGlobalSparkGlobalConfig() = _globalSparkConfig

  def initializeGlobalConfigs() {

    val confFile = Paths.get(_globalConfigFilePath).toFile
    val config = ConfigFactory.parseFile(confFile)

    _globalConf = ConfigFactory.load(config)
    _globalSparkConfig = new SparkConfig(_globalConf.atPath("taxirides-app.global-config.spark-config"))
  }

}