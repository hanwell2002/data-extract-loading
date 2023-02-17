import com.newhopebootcamps.config.ApplicationConfiguration
import com.newhopebootcamps.util.{CommonUtils, CsvFileUtil}
import com.newhopebootcamps.helper.CsvDemoHelper
import com.newhopebootcamps.dao.{CityDao, CountryDao}
import com.newhopebootcamps.service.EmailService
import org.slf4j.LoggerFactory

object Main {
  val logger = LoggerFactory.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    logger.info("Application Started................")
    println(ApplicationConfiguration.url)

    val esvr = new EmailService

    esvr.register("Elon@hostmail.com")

    generateReport

    CsvDemoHelper.write("/opt/bootcamps/reports/demo.csv")
    logger.info("Application Completed.................")
    println("Report generated!")
  }

  def generateReport() {
    // Find COUNTRY by Continent
   // val sql = "SELECT * from country WHERE continent='North America'"
    val dao = new CountryDao
    val resultSet = dao.findCountryByQuery("South America")

    val csvName = composeFileName
    logger.info(csvName)
    CsvFileUtil.writeAll(resultSet, csvName)

    // Find CITY by Country Code
    val countrycode = "USA"
    val query = s"SELECT * from city where countrycode='${countrycode}'"
    val cityDao = new CityDao
    cityDao.read(query)

  }

  def composeFileName: String = {
    val dateString = CommonUtils.currentDateString("yyyy-MM-dd")
        "/opt/bootcamps/reports/city_" + dateString + ".csv"
  }

  def register(email: String): Unit = {
    val service = new EmailService
    service.register(email)
  }

}