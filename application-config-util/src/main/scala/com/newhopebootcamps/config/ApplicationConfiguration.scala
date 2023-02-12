package com.newhopebootcamps.config

import com.typesafe.config.ConfigFactory

import java.io.File

object ApplicationConfiguration {
//  var host: String = ""
//  var url: String = ""
//  var username: String = ""
//  var password: String = ""

  val defaults = ConfigFactory.load()

  val fromSource = ConfigFactory.parseResources("database.conf").withFallback(defaults)

  val file = new File("C:/var/config/database.cfg")
  val conf = ConfigFactory.parseFile(file).withFallback(fromSource).withFallback(defaults)

  val url = conf.getString("database.url")
  val username = conf.getString("database.username")
  val password = conf.getString("database.password")
  val host = conf.getString("database.host")


 /* def initialize(): Unit = {
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
  }*/
}
