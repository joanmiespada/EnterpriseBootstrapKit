package logic

import data.entity.User
import models._
import data.database._
import com.outworkers.phantom.dsl._

import scala.concurrent.Future

class cUserLogic extends UsersProvider {

  private def mapping(userModel: UserModel): User  =
     User( userModel.Id, userModel.Name, userModel.Surname, userModel.Password, userModel.Email, userModel.RegistrationDate )

  private def mapping(user: User): UserModel =
    new UserModel(user.id, user.name, user.surname, user.email, user.password, user.registrationDate )

  def Create(user:UserModel): Future[Boolean]  = {

    val f =  database.usersTable.store( mapping(user) )
    for(
       result <- f
    ) yield  result.isExhausted()

  }

/*
  def Update(user:UserModel): Boolean = {
    storage.Update(user)
  }

  def Delete(Id:String): Boolean = {
    storage.Delete(Id)
  }

  def GetById(Id:String): UserModel = {
    storage.GetById(Id)
  }

  def GetByEmail(email:String): List[UserModel] = {
    storage.GetByEmail(email)
  }
*/
}

object UserLogic extends cUserLogic

