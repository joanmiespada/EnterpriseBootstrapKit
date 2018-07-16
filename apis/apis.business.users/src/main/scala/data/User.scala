package data

import com.datastax.driver.core._
import com.datastax.driver.core.querybuilder.{QueryBuilder => QB}
import scala.collection.JavaConverters._
import scala.concurrent._

import models.UserModel


class UserData(session: Session)(implicit  ec: ExecutionContext) extends UserConnection {

  private val table = "user_list"
  private val fieldId = "id"
  private val fieldEmail = "email"
  private val fieldName = "name"
  private val fieldSurname = "surname"
  private val fieldPassword = "password"


  def createTable: Future[ResultSet] =
  {
    val query = s"create table if not exists $table ($fieldId int primary key, $fieldName text, $fieldSurname text, $fieldEmail text, $fieldPassword text)"
    session.executeAsync(query).map( _=>{})
  }

  def dropTable: Future[it] = {
    val query = s"drop table if exists $table"
    session.executeAsync(query).map(_ => {})
  }


  override def Create(user:UserModel) : Boolean = {
    val query = {
      QB.insertInto(table)
        .value(fieldId, user.Id)
        .value(fieldName, user.Name)
        .value(fieldSurname, user.Surname)
        .value(fieldEmail, user.Email)
        .value(fieldPassword, user.Password)
    }
    session.executeAsync(query).map(_ => {})
  }

  override def Update(user:UserModel): Boolean = {
    val query = {
      QB.update(table)
        .`with`(QB.set(fieldName, user.Name))
        .and(QB.set(fieldSurname, user.Surname))
        .and(QB.set(fieldEmail, user.Email))
        //.and(QB.set(fieldPassword, user.Password))
        .where(QB.eq(fieldId, user.Id))
    }
    session.executeAsync(query).map(_ => {})
  }

  override def Delete(id:String): Boolean = {
    val query = {
      QB.delete().all()
        .from(table)
        .where(QB.eq(fieldId, id))
    }
    session.executeAsync(query).map(_ => {})
  }

  override def GetById(id:String): Seq[UserModel] = {
    val query = {
      QB.select(fieldId, fieldName, fieldSurname, fieldEmail)
        .from(table)
        .where(QB.eq(fieldId, id))
    }
    for{
      resultSet <- session.executeAsync(query)
    } yield {
      resultSet
        .asScala
        .map(mapUserFromDb)
        .toSeq
    }
  }

  override def GetByEmail(email:String): Seq[UserModel] = {
    val query = {
      QB.select(fieldId, fieldName, fieldSurname, fieldEmail)
        .from(table)
        .where(QB.eq(fieldEmail, email))
    }

    for {
      resultSet <- session.executeAsync(query)
    } yield {
      resultSet
        .asScala
        /*.map(row => new UserModel(row.getInt(fieldId),
                                  row.getString(fieldName),
                                  row.getString(fieldSurname),
                                  row.getString(fieldEmail)))*/
          .map(mapUserFromDb)
        .toSeq
    }


  }

  def mapUserFromDb = (row:Unit) => new UserModel(row.getInt(fieldId),
                                  row.getString(fieldName),
                                  row.getString(fieldSurname),
                                  row.getString(fieldEmail)))

}
