name := "apis.business.users"

version := "0.1"

scalaVersion := "2.12.6"

lazy val Versions = new {
  val phantom = "2.14.0"
  val util = "0.40.0"
}

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.25"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "com.datastax.cassandra" % "cassandra-driver-core" % "3.5.0"

libraryDependencies += "com.thedeanda" % "lorem" % "2.1"
libraryDependencies += "com.outr" %% "hasher" % "1.2.1"

libraryDependencies ++= Seq(
  "com.outworkers"  %%  "phantom-dsl" % Versions.phantom,
  "com.outworkers"  %%  "phantom-streams"   % Versions.phantom,
  "com.outworkers"  %%  "util-testing" % Versions.util % Test
)



