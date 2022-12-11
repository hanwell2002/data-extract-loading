import com.newhopebootcamps.util.ReadCsvUtil
import java.sql.{Connection, DriverManager, ResultSet}
import com.github.tototoshi.csv._
import com.newhopebootcamps.util.ReadCsvUtil
import java.io.FileWriter
import scala.collection.mutable.ListBuffer

object Main {
  def main(args: Array[String]): Unit = {
    databaseAccessTest()
    csvTest()
  }

  def databaseAccessTest() {
    // connect to the database
    val driver = "org.postgresql.Driver"
    val url = "jdbc:postgresql://localhost:5432/postgres"
    val con_str = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=MY_PASSWORD"

    val conn = DriverManager.getConnection(con_str)
    try {
      val stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
      val rs = stm.executeQuery("SELECT * from city")
      while (rs.next) {
        println(rs.getString("name"))
      }
    } finally {
      conn.close()
    }
    // Class.forName(driver)
    var connection: Connection = null
    val query = "SELECT * from city"
    val username = "postgres"
    val password = "MY_PASSWORD
    try {
      // classOf[org.postgresql.Driver]
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      import java.sql.ResultSet
      val statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
      val resultSet = statement.executeQuery("SELECT * from country")

      while (resultSet.next) {
        val countryName = resultSet.getString("code")
        val location = resultSet.getString("region")
        println("country-name = %s, location = %s".format(countryName, location))
      }

    } catch {
      case e => e.printStackTrace
    }
    connection.close()

    /**
     * import java.sql.Connection
     * import java.sql.DriverManager
     * val url: String = "jdbc:postgresql://localhost/postgres"
     * val props: Nothing = new Nothing
     * props.setProperty("user", "postgres")
     * props.setProperty("password", "Admin$777")
     * props.setProperty("ssl", "true")
     * val conn: Connection = DriverManager.getConnection(url, props)
     *
     * val url: String = "jdbc:postgresql://localhost/postgres?user=postgres&password=Admin$777&ssl=true"
     * val conn: Connection = DriverManager.getConnection(url)
     */
  }

  def csvTest():
  Unit = {
    ReadCsvUtil.read()
    ReadCsvUtil.write()
  }

}