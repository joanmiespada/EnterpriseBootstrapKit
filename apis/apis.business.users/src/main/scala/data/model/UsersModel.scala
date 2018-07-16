package data.model

import java.util.UUID
import com.outworkers.phantom.dsl._
import org.joda.time.DateTime
import scala.concurrent.{Future => ScalaFuture}

import data.entity.User

abstract class UsersModel extends Table[UsersModel,User] //with RootConnector
{
  override def tableName: String = "users"

  object id extends UUIDColumn with PartitionKey
  object name extends OptionalStringColumn
  object surname extends  OptionalStringColumn
  object password extends  StringColumn
  object email extends  StringColumn with Index
  object registrationDate extends DateTimeColumn
/*
  def store(user:User): ScalaFuture[ResultSet]={

    insert.value(_.id,user.id)
      .value(_.name,user.name)
      .value(_.surname,user.surname)
      .value(_.password,user.password)
      .value(_.email,user.email)
      .value(_.registrationDate,user.registrationDate)
      .future()
  }

  def getById(id:UUID): ScalaFuture[Option[User]] = {
    select.where(_.id eqs id)
      .allowFiltering()
      .one()
  }

  def getLimit(limit: Int): ScalaFuture[ResultSet] = {
    select.limit(limit).future()
  }

  def getByEmail(email:String): ScalaFuture[Seq[User]] = {
    select.where(_.email eqs email).fetch() //contains
  }

  def getAll(limit:Int): ScalaFuture[Seq[User]] = {
    select.fetch()
    //select.where(_.surname eqs "test").orderBy(_.surname desc).limit(limit).paginateRecord(_.setFetchSize(limit))
  }

  def update(id:UUID, user: User): ScalaFuture[ResultSet] = {
    update.where(_.id eqs id)
      .modify(_.email setTo user.email)
      .and(_.name setIfDefined user.name)
      .and(_.surname setIfDefined user.surname)
      //.consistencyLevel_=(ConsistencyLevel.QUORUM)
      .future()
  }

  def delete(id:UUID): ScalaFuture[ResultSet] = {
    delete.where(_.id eqs id).future()
  }
*/
}
