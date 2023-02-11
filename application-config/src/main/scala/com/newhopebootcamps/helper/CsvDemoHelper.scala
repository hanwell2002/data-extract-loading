package com.newhopebootcamps.helper

import com.github.tototoshi.csv._
import com.newhopebootcamps.util.CommonUtils.isEmpty

import java.io._
import java.sql.ResultSet

object CsvDemoHelper {
  def read(filePath: String): Unit = {
    println("Reading CSV")
    val reader = CSVReader.open(new File(filePath))
    //1.
    // reader.foreach(println)
    //2.
    // val all =  reader.all()
    // all.foreach(fields => println(fields))
    //3.
    val it = reader.iterator
    while (it.hasNext) {
      val row = it.next
      row.foreach {
        col => print(col + " ")
      }
      println("")
    }

    reader.close()
    println("Completed reading CSV")
  }

  def write(filePath: String): Unit = {
    println("Writing CSV ...... ")

    val writer = CSVWriter.open(new FileWriter(filePath))
    writer.writeAll(List(List("a", "b", "c"), List("d", "e", "f"), List("1", "2", "3")))
  }

  def rsWrite(rs: ResultSet, headerString: String, filePath: String): Unit = {
    val csvWriter = CSVWriter.open(new FileWriter(filePath))
    var rl: List[List[String]] = List.empty

    if (!isEmpty(headerString)) {
      val header = headerString.split(",").toList
      rl :+= header
      println("CSV Header: ")
      header.foreach(println)
    }
    else
      println("CSV no header")

    while (rs.next) {
      var rec: List[String] = List.empty[String]
      val countryName = rs.getString("code")
      val location = rs.getString("region")

      rec :+= countryName
      rec :+= location

      rl :+= rec
    }

    csvWriter.writeAll(rl)
  }

  @scala.annotation.tailrec
  def getResult(resultSet: ResultSet, list: List[String] = Nil): List[String] = {
    if (resultSet.next()) {
      val value = resultSet.getString(1)
      getResult(resultSet, value :: list)
    }
    else {
      list
    }
  }

}
