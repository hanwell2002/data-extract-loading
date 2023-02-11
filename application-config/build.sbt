ThisBuild / version := "1.0.1"

ThisBuild / scalaVersion := "2.12.15"

lazy val root = (project in file("."))
   .settings(
   name := "application"
)

lazy val _postgresJDBCVersion = "42.5.1"

libraryDependencies ++= Seq (
  //"com.oracle.database.jdbc" % "ojdbc8" % "21.3.0.0",
  "org.postgresql" % "postgresql" % _postgresJDBCVersion,
  "com.github.tototoshi" %% "scala-csv" % "1.3.10",
   "com.typesafe" % "config" % "1.4.2"
)

