name := """web-project"""
version := "1.0-SNAPSHOT"
scalaVersion := "2.12.2"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
pipelineStages := Seq(digest)

libraryDependencies ++= Seq(
  jdbc,
  ehcache,
  ws,
  "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided",
  "com.github.rbontekoe" % "surveillance" % "0.0.1" % "provided"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"