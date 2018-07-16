package data.entity

import java.util.UUID

import org.joda.time.DateTime

case class User (
                  id: UUID,
                  name: Option[String],
                  surname: Option[String],
                  password: String,
                  email: String,
                  registrationDate: DateTime
                )