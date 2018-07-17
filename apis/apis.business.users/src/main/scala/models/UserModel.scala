package models

import java.util.{ UUID}

import org.joda.time.DateTime


class UserModel (
          var _Id: UUID = UUID.randomUUID(),
          var _Name:  Option[String],
          var _Surname: Option[String],
          var _Email:String = "",
          var _PasswordHash: String = "",
          var _RegistrationDate: DateTime = null
          ) {

  def Name: Option[String] = _Name
  def Name_= (newValue: String):Unit ={ _Name = Option(newValue) }

  def Surname: Option[String]  = _Surname
  def Surname_= (newValue: String):Unit ={ _Surname = Option(newValue) }

  def Id:UUID = _Id
  def Id_= (newValue: UUID):Unit ={ _Id = newValue }

  def Email:String  = _Email
  def Email_= (newValue: String):Unit ={ _Email = newValue }

  def Password:String  = _PasswordHash
  def Password_= (newValue: String):Unit ={ _PasswordHash = newValue }

  def RegistrationDate:DateTime = _RegistrationDate
  def RegistrationDate_= (newValue: DateTime):Unit ={ _RegistrationDate = newValue }

  override  def toString():String = s"Id: $Id, Name: $Name, Surname: $Surname, Email: $Email"


}
