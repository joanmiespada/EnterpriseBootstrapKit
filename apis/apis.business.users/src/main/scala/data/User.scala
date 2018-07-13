package data

import models._

class UserData {

  def Save(user:UserModel) : Boolean = {
    true
  }

  def Update(user:UserModel): Boolean = {
    true
  }

  def Delete(id:String): Boolean = {
    true
  }

  def GetById(id:String): UserModel = {
    val res = new UserModel
    res
  }

  def GetByEmail(email:String): List[UserModel] = {
    null
  }

}
