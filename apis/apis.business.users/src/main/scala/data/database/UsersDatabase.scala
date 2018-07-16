package data.database

import com.outworkers.phantom.connectors.CassandraConnection
import com.outworkers.phantom.dsl._
import scala.concurrent.{Future => ScalaFuture}

import data.entity.User
import data.model.UsersModel
import data.connector.Connector._



class UsersDatabase(override val connector: CassandraConnection) extends Database[UsersDatabase](connector)
{
    object UsersModel extends UsersModel with connector.Connector

    //def store(user:User): ScalaFuture[ResultSet] = {
    //    UsersModel.store(user)
   // }

}

object Database extends UsersDatabase(connector)
