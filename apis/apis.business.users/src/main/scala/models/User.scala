package models

import java.util.UUID
import org.joda.time.DateTime


class UserModel (
          var _Id: UUID = UUID.randomUUID(),
          var _Name: String = "",
          var _Surname: String = "",
          var _Email:String = "",
          var _PasswordHash: String = "",
          var _RegistrationDate: DateTime = null
          ) {

  def Name:String = _Name
  def Name_= (newValue: String):Unit ={ _Name = newValue }

  def Surname:String  = _Surname
  def Surname_= (newValue: String):Unit ={ _Surname = newValue }

  def Id:UUID = _Id
  def Id_= (newValue: UUID):Unit ={ _Id = newValue }

  def Email:String  = _Email
  def Email_= (newValue: String):Unit ={ _Email = newValue }

  def Password:String  = _PasswordHash
  def Password_= (newValue: String):Unit ={ _PasswordHash = newValue }

  def RegistrationDate:DateTime = _RegistrationDate
  def RegistrationDate_= (newValue: DateTime):Unit ={ _RegistrationDate = newValue }
  //override  def toString():String =
  //  s"Id: $Id, Name: $_Name, Surname: $_Surname, Email: $_Email"


}
