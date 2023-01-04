ThisBuild / version := "1.0.0"

ThisBuild / scalaVersion := "2.12.15"

lazy val root = (project in file("."))
   .settings(
   name := ""
)

lazy val _mysqlJDBCVersion = "8.0.31"
lazy val _postgresJDBCVersion = "42.5.1"

libraryDependencies ++= Seq (
  "com.oracle.database.jdbc" % "ojdbc8" % "21.3.0.0",
  "mysql" % "mysql-connector-java" % _mysqlJDBCVersion,
  "org.postgresql" % "postgresql" % _postgresJDBCVersion,
  "com.github.tototoshi" %% "scala-csv" % "1.3.10"
)

