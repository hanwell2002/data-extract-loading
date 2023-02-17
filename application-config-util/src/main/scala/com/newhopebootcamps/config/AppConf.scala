package com.newhopebootcamps

package object config {
  import com.typesafe.config.ConfigFactory
  import java.io.File

  object AppConf {
    val defaults = ConfigFactory.load()

    val fromSource = ConfigFactory.parseResources("kafka.conf")

    val file = new File(defaults.getString("appinfo.config"))

    val conf = ConfigFactory.parseFile(file).withFallback(fromSource).withFallback(defaults)

    val url = conf.getString("database.url")
    val username = conf.getString("database.username")
    val password = conf.getString("database.password")
  }

}