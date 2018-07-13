package logic

import models._
import data._

class UserLogic(storage:UserData ) {

  def Create(user:UserModel): Boolean = {
    storage.Save(user)
  }

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

}
