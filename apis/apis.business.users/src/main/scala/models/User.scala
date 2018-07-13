package models

class UserModel (
          var _Id: String = "",
          var _Name: String = "",
          var _Surname: String = "",
          var _Email:String = "",
          var _PasswordHash: String = ""
          ) {

  def Name:String = _Name
  def Name_= (newValue: String):Unit ={ _Name = newValue }

  def Surname:String  = _Surname
  def Surname_= (newValue: String):Unit ={ _Surname = newValue }

  def Id:String = _Name
  def Id_= (newValue: String):Unit ={ _Id = newValue }

  def Email:String  = _Email
  def Email_= (newValue: String):Unit ={ _Email = newValue }

  def Password:String  = _PasswordHash
  def Password_= (newValue: String):Unit ={ _PasswordHash = newValue }

  //override  def toString():String =
  //  s"Id: $Id, Name: $_Name, Surname: $_Surname, Email: $_Email"


}
