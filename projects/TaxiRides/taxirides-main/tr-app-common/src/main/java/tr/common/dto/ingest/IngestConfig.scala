package tr.common.dto.ingest

import scala.collection.JavaConverters._
import com.typesafe.config.Config
import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import scala.collection.mutable.ListBuffer

class IngestConfig(_ingestConfig: Config) {

  def getConfig() = _ingestConfig

  def getDataIngestNodeConfig() = _ingestConfig.getConfig("taxirides-app.tr-data-ingest")

  def getApplicationNodeConfig() = {
    getDataIngestNodeConfig.getConfig("application")
  }

  def getIngestApplicationName() = getApplicationNodeConfig.getString("name")

  def getNoOfInputDataNodes() = {
    _ingestConfig.getString("taxirides-app.tr-data-ingest.datanodes.input-data-nodes.no-of-data-nodes").toInt
  }

  def getConcurrencyForAnInputDataNode(dataNodeIndexNo: Int) = getDataIngestNodeConfig().getConfig("datanodes.input-data-nodes-info.input-data-node-" + dataNodeIndexNo).getInt("data-ingest-concurrency")

  def getLocationsForAnInputDataNode(dataNodeIndexNo: Int) = {

    println("Entered into getLocationsForAnInputDataNode")
    getDataIngestNodeConfig().getConfig("datanodes.input-data-nodes-info.input-data-node-" + dataNodeIndexNo).getList("locations").unwrapped().toArray()
  }

}

object IngestConfig {

  def main(args: Array[String]) {

    val confFile = Paths.get("src/test/resources/tr-data-ingest.json").toFile
    val config = ConfigFactory.parseFile(confFile)

    val tempConf = ConfigFactory.load(config)
    println(config)
    println(config.getString("taxirides-app.tr-data-ingest.datanodes.input-data-nodes.no-of-data-nodes"))

  }

}