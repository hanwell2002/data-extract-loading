package com.newhopebootcamps.util

import java.io._
import java.sql.ResultSet
import com.github.tototoshi.csv._

object CsvFileUtil {
  def writeAll(rs: ResultSet, filePath: String, isWriteHeader: Boolean = true): Unit = {
    val csvWriter = CSVWriter.open(new FileWriter(filePath))
    var rl: List[List[String]] = List.empty
    val columnNames = getColumnNames(rs)

    if (isWriteHeader) {
      rl :+= columnNames
    }

    rl ++= extractRecords(rs)
    csvWriter.writeAll(rl)
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


}
