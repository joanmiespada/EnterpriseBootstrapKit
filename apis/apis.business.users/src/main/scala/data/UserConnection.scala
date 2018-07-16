package data

import models.UserModel

trait UserConnection
{
  def Create(user:UserModel) : Boolean
  def Update(user:UserModel): Boolean
  def Delete(id:String): Boolean
  def GetById(id:String): UserModel
  def GetByEmail(email:String): List[UserModel]

}