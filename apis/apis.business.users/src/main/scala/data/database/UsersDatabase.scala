package data.database

import com.outworkers.phantom.connectors.CassandraConnection
import com.outworkers.phantom.dsl._
import data.repository.UsersRepository
import data.connector.Connector._



class cUsersDatabase(override val connector: CassandraConnection)
  extends Database[cUsersDatabase](connector)
{
    object usersTable extends UsersRepository with Connector

    //def store(user:User): ScalaFuture[ResultSet] = {
    //    UsersModel.store(user)
   // }

}

object UsersDatabase extends cUsersDatabase(connection)



