import com.newhopebootcamps.util.CsvFileUtil

import java.sql.{Connection, DriverManager, ResultSet}
import com.github.tototoshi.csv._
import com.newhopebootcamps.helper.CsvDemoHelper
import com.newhopebootcamps.util.CsvFileUtil

import java.io.{File, FileWriter}
import scala.collection.mutable.ListBuffer
import com.typesafe.config._

object Main {
  private val csvFile = "C:/var/output/resultset.csv"

  def main(args: Array[String]): Unit = {
    extractAllDataToCsvDemo

  //  loadResourceConfig

    val envMap = sys.env

    envMap.foreach{

      pair=>
        println("k = " + pair._1 + ":   value" + pair._2)

    }


  }

  def loadResourceConfig() {
    val defaults = ConfigFactory.load()

    val conf = ConfigFactory.parseResources("database.conf").withFallback(defaults)
    val url = conf.getString("database.url")
    val username = conf.getString("database.username")
    val password = conf.getString("database.password")
    val host = conf.getString("database.host")
    println(s"url=$url, username=$username, pwd = $password, host= $host")


    val appName = conf.getString("appinfo.name")

    println(s"appName=$appName")

    println(conf.getString("Modules.Logging.logDb"))
    println(conf.getString("Modules.Tenants.tenantsDb"))
  }

    def extractAllDataToCsvDemo() {
    // classOf[org.postgresql.Driver]
    val defaults = ConfigFactory.load()

      val customizeConfgi = defaults.getString("appinfo.config")

    val file = new File(customizeConfgi)

    val conf = ConfigFactory.parseFile(file).withFallback(defaults)
    val url = conf.getString("database.url")
    val username = conf.getString("database.username")
    val password = conf.getString("database.password")
    println(s"url=$url, username=$username, pwd = $password")

    val appName = conf.getString("appinfo.name")

    println(s"appName=$appName")

    println(conf.getString("Modules.Logging.logDb"))
    println(conf.getString("Modules.Tenants.tenantsDb"))


    /*


      var connection: Connection = null
      val query = "SELECT * from country"

      try {
        connection = DriverManager.getConnection(url, username, password)

        // create the statement, and run the query
        import java.sql.ResultSet
        val statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        val resultSet = statement.executeQuery(query)

        while (resultSet.next) {
             val countryName = resultSet.getString("code")
             val location = resultSet.getString("region")
             println("country-name = %s, location = %s".format(countryName, location))
           }

        println("###################################################")

       // CsvFileUtil.writeAll(resultSet, csvFile, true)

        println("-----------------------completed  ------------------------")

      } catch {
            case e => e.printStackTrace
      }
      connection.close()

    */

  }


}