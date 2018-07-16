name := "apis.business.users"

version := "0.1"

scalaVersion := "2.12.6"

val PhantomVersion = "2.14.0"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "com.datastax.cassandra" % "cassandra-driver-core" % "3.5.0"
//libraryDependencies += "com.outworkers" % "phantom-dsl_2.11" % "2.24.8"

libraryDependencies ++= Seq(
  "com.outworkers" %% "phantom-dsl" % PhantomVersion
)



