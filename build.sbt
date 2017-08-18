name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies += ws
libraryDependencies += "org.typelevel" %% "cats-core" % "1.0.0-MF"
