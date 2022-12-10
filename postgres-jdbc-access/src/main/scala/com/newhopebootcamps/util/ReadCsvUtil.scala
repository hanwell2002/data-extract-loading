package com.newhopebootcamps.util

import java.io._
import java.util.NoSuchElementException
import scala.io.Source
// import com.github.tototoshi.csv.CSVReader
import com.github.tototoshi.csv._

object ReadCsvUtil {
  def read(): Unit = {
    println("Reading CSV")
    val reader = CSVReader.open(new File("g:/School/data/sample.csv"))
    reader.readNext()

    // reader.all()
    reader.foreach(fields => println(fields))

    reader.close()
    println("Completed reading CSV")

  }

  def write(): Unit = {
    println("Writing CSV")
   /* val resultSet2: java.sql.ResultSet = statement.executeQuery(query)
    val csvWriter = new CSVWriter(new FileWriter("Output.csv"), ',')
    csvWriter.writeAll(resultSet2, true)
    csvWriter.close()*/

    val writer = CSVWriter.open(new FileWriter("g:/School/data/test.csv"))
    writer.writeAll(List(List("a", "b", "c"), List("d", "e", "f")))
/*
    using(CSVWriter.open(new FileWriter("test.csv"))) { writer =>
      writer.writeAll(List(List("a", "b", "c"), List("d", "e", "f")))
    }
*/
  }
}
