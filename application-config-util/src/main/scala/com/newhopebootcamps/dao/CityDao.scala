package com.newhopebootcamps.dao

import java.sql.{ResultSet, SQLException}

class CityDao extends Dao {

  def read(query: String) {
    try {
      // create the statement, and run the query
      val statement = getConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
      val resultSet = statement.executeQuery(query)

      while (resultSet.next) {
        val code = resultSet.getString("countrycode")
        val name = resultSet.getString("name")
        logger.debug("city name = %20s, country code = %s".format(name, code))
      }

      closeConnection
    } catch {
      case e: SQLException => logger.error("SQLException: %s", e.getMessage)
      case _: Throwable => logger.error("Exception: Unknown exception.")

    }

  }
}
