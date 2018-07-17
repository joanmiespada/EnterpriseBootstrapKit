package data.database

import com.outworkers.phantom.database.DatabaseProvider

trait UsersProvider extends DatabaseProvider[cUsersDatabase] {
  override val database: cUsersDatabase = UsersDatabase
}