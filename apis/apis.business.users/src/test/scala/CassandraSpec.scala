import com.outworkers.phantom.database.DatabaseProvider
import data.database.{Database, UsersDatabase}
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures


trait UsersDbProvider extends DatabaseProvider[UsersDatabase] {
  override def database: UsersDatabase = Database
}

trait CassandraSpec extends FlatSpec
  with Matchers
  with Inspectors
  with ScalaFutures
  with OptionValues
  with BeforeAndAfterAll
  with UsersDbProvider