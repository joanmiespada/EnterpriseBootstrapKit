import com.outworkers.phantom.database.DatabaseProvider
import data.database.{UsersDatabase, cUsersDatabase}
import org.scalatest._
import org.scalatest.concurrent._


trait UsersDbProvider extends DatabaseProvider[cUsersDatabase] {
  override val database: cUsersDatabase = UsersDatabase
}

trait CassandraSpec extends AsyncFunSuite// AsyncFlatSpec
  with Matchers
  with Inspectors
  with ScalaFutures
  with OptionValues
  with BeforeAndAfterAll
  with UsersDbProvider

