import com.newhopebootcamps.util.CsvFileUtil

import java.sql.{Connection, DriverManager, ResultSet}
import com.github.tototoshi.csv._
import com.newhopebootcamps.helper.CsvDemoHelper
import com.newhopebootcamps.util.CsvFileUtil

import java.io.{File, FileWriter}
import scala.collection.mutable.ListBuffer
import com.typesafe.config._
import com.newhopebootcamps.config.ApplicationConfiguration
import com.newhopebootcamps.dao.{CityDao, CountryDao}
import org.slf4j.LoggerFactory

object Main {
  val logger = LoggerFactory.getLogger(this.getClass)


  def main(args: Array[String]): Unit = {
    logger.info("Application Started................")

    extractAllDataToCsvDemo

    logger.warn("Application Completed.................")


  }

  def extractAllDataToCsvDemo() {
    val dao = new CountryDao
    dao.read


    val cityDao = new CityDao
    cityDao.read


  }


}