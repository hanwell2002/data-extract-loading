package com.newhopebootcamps.dao

import com.newhopebootcamps.config.{ApplicationConfiguration, Logging}

import java.sql.{Connection, DriverManager, SQLException}

class Dao extends Logging {
  val url = ApplicationConfiguration.url
  val username = ApplicationConfiguration.username
  val password = ApplicationConfiguration.password

  private val connection: Connection = getConnection

  def getConnection: Connection = {
    logger.debug(s"connection: url=$url, username=$username, pwd = $password")

    try {
      val conn: Connection = DriverManager.getConnection(url, username, password)
      conn
    } catch {
      case e: SQLException => logger.error(e.getMessage)
        null
    }
  }

  def closeConnection(): Boolean = {
    var ret = false;
    try {
      if (connection != null) {
        connection.close()
      }

      ret = true

    } catch {
      case e: SQLException => logger.error("SQLException: %s", e.getMessage)
      case _: Throwable => logger.error("Exception: Unknown exception.")
        ret = false
    } finally {
      logger.info("Closing connection.")
    }

    ret

  }

}
