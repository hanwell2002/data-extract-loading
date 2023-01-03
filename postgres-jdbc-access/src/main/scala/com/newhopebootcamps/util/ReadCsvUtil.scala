package com.newhopebootcamps.util

import java.io._
import java.sql.ResultSet
import java.util.NoSuchElementException
import scala.io.Source
import com.github.tototoshi.csv._
import com.newhopebootcamps.util.CommonUtils.isEmpty

object ReadCsvUtil {
  def read(filePath: String): Unit = {
    println("Reading CSV")
    val reader = CSVReader.open(new File(filePath))
    reader.readNext()
    // reader.all()
    reader.foreach(fields => println(fields))

    reader.close()
    println("Completed reading CSV")
  }

  def write(filePath:String): Unit = {
    println("Writing CSV ...... ")

    val writer = CSVWriter.open(new FileWriter(filePath))
    writer.writeAll(List(List("a", "b", "c"), List("d", "e", "f")))
  }

  def writeAll(rs: ResultSet, filePath: String, isWriteHeader: Boolean = true): Unit = {
    val demoCsvWriter = CSVWriter.open(new FileWriter(filePath))
    var rl: List[List[String]] = List.empty
    val columnNames = getColumnNames(rs)

    if (isWriteHeader) {
      rl :+= columnNames
    }

    rl ++= extractRecords(rs)
    demoCsvWriter.writeAll(rl)
  }

  def getColumnNames(rs: ResultSet): List[String] = {
    var columnList: List[String] = List.empty[String]
    val metaData = rs.getMetaData
    val columnCount = metaData.getColumnCount

    val cols = (1 to columnCount).map { k =>
      val columnName = metaData.getColumnLabel(k)
      columnList :+= columnName
    }

    columnList
  }

  def extractRecords(rs: ResultSet): List[List[String]] = {
    var dataList: List[List[String]] = List.empty
    val columnNames = getColumnNames(rs)
    while (rs.next) {
      var columnList: List[String] = List.empty[String]
      for (name <- columnNames) {
        val value = rs.getString(name)
        columnList :+= value
      }

      dataList :+= columnList
    }

    dataList
  }

  def rsWrite2(rs: ResultSet, headerString: String, filePath: String): Unit = {
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
