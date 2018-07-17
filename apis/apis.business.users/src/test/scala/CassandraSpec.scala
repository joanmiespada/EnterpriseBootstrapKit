package test

import data.database.{ UsersProvider }
import org.scalatest._
import org.scalatest.concurrent._

trait CassandraSpec extends AsyncFunSuite// AsyncFlatSpec
  with Matchers
  with Inspectors
  with ScalaFutures
  with OptionValues
  with BeforeAndAfterAll
  with UsersProvider

