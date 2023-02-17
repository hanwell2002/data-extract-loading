ThisBuild / version := "1.0.1"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "application-config-util",
    assembly / mainClass := Some("Main")
  )

enablePlugins(AssemblyPlugin)

lazy val _postgresJDBCVersion = "42.5.1"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % _postgresJDBCVersion,
  "com.github.tototoshi" %% "scala-csv" % "1.3.10",
  "com.typesafe" % "config" % "1.4.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "commons-codec" % "commons-codec" % "1.15",
)

