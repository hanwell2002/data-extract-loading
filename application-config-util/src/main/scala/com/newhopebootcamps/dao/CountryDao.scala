package com.newhopebootcamps.dao

import com.newhopebootcamps.config.ApplicationConfiguration
import com.newhopebootcamps.util.CsvFileUtil

import java.sql.{Connection, DriverManager}

class CountryDao {

  def read() {

    val url = ApplicationConfiguration.url
    val username = ApplicationConfiguration.username
    val password = ApplicationConfiguration.password

    println(s"read:> url=$url, username=$username, pwd = $password")

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
       // println("country-name = %s, location = %s".format(countryName, location))
      }
    } catch {
      case e => e.printStackTrace
    }
    connection.close()
  }
}
