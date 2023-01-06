import com.newhopebootcamps.util.CsvFileUtil

import java.sql.{Connection, DriverManager, ResultSet}
import com.github.tototoshi.csv._
import com.newhopebootcamps.helper.CsvDemoHelper
import com.newhopebootcamps.util.CsvFileUtil

import java.io.FileWriter
import scala.collection.mutable.ListBuffer

object Main {
  private val csvFile = "C:/var/output/resultset.csv"

  def main(args: Array[String]): Unit = {
    databaseAccessDemo()
    extractAllDataToCsvDemo
    csvTest()
  }

  def databaseAccessDemo() {
    val driver = "org.postgresql.Driver"
    val con_str = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=MY_DB_PWD"

    // connect to the database
    // Class.forName(driver)
    val conn = DriverManager.getConnection(con_str)
    /**
     * import java.sql.Connection
     * import java.sql.DriverManager
     * val url: String = "jdbc:postgresql://localhost/postgres"
     * val props: Nothing = new Nothing
     * props.setProperty("user", "postgres")
     * props.setProperty("password", "MY_PASSWORD")
     * props.setProperty("ssl", "true")
     * val conn: Connection = DriverManager.getConnection(url, props)
     *
     * val url: String = "jdbc:postgresql://localhost/postgres?user=postgres&password=MY_DB_PWD&ssl=true"
     * val conn: Connection = DriverManager.getConnection(url)
     */

    try {
      val stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
      val rs = stm.executeQuery("SELECT * from city")
      while (rs.next) {
        println(rs.getString("name"))
      }
    } finally {
      conn.close()
    }

  }

  def extractAllDataToCsvDemo() {
    // classOf[org.postgresql.Driver]
    val url = "jdbc:postgresql://localhost:5432/postgres"
    val username = "postgres"
    val password = "MY_DB_PWD"
    var connection: Connection = null
    val query = "SELECT * from country"

    try {
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the query
      import java.sql.ResultSet
      val statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
      val resultSet = statement.executeQuery(query)
      /*   while (resultSet.next) {
           val countryName = resultSet.getString("code")
           val location = resultSet.getString("region")
           println("country-name = %s, location = %s".format(countryName, location))
         }
     */
      println("###################################################")

      CsvFileUtil.writeAll(resultSet, csvFile, true)

      println("###################################################")
      // check if csv file generated
      checkCsvFile()

      // add  first column of the table to list
      // val list = ReadCsvUtil.getResult(resultSet)
      println("-----------------------completed  ------------------------")

    } catch {
          case e => e.printStackTrace
    }
    connection.close()


  }

  private def csvTest(): Unit = {
    val csvDemoFile ="C:/var/output/demo-csv-write-read.csv"
    CsvDemoHelper.write(csvDemoFile)
    CsvDemoHelper.read(csvDemoFile)
  }

  private def checkCsvFile(): Unit = {
    println("Reading CSV ... ")
    val reader = CSVReader.open(csvFile)
    reader.readNext()
    // reader.all()
    reader.foreach(fields => println(fields))
    reader.close()
    println("Completed reading CSV")
  }


}