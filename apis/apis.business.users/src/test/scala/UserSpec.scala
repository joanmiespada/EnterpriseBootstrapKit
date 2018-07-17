import java.util.UUID

import com.outworkers.phantom.dsl._
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
//import data.entity.User
import org.joda.time.DateTime
import com.roundeights.hasher.Implicits._
import models.UserModel

import scala.language.postfixOps

class UserSpec extends CassandraSpec {


  override def beforeAll(): Unit = {
    super.beforeAll()
    //database.create()
  }

  override def afterAll(): Unit = {
    super.afterAll()
    //database.truncate()
  }

  /*def randomUser(): User = {

    val lorem:Lorem = LoremIpsum.getInstance()
    val pass = "pepe".md5

    User( UUID.randomUUID(), Option( lorem.getFirstName() ),Option( lorem.getName() ),
          pass, lorem.getEmail() ,DateTime.now())
  }*/

  def randomUser(): UserModel = {

    val lorem:Lorem = LoremIpsum.getInstance()
    val pass = "pepe".md5

    val res:UserModel =  new UserModel( UUID.randomUUID(), Option( lorem.getFirstName() ),Option( lorem.getName() ),
          pass, lorem.getEmail() ,DateTime.now())
  }

 test("A User should stored in cassandra"){

    //val user = new UserModel("1234fer" + n.toString , "pepe","jose","pepe@jose.com","asdfg1234")
    val user = randomUser()  //User( UUID.randomUUID(), Option("name"),Option("surname"),"password","email",DateTime.now())
     database.usersTable.store( user ) map { result=>
       result isExhausted() shouldBe true
     }


  }

  /*it should "empty password" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }*/
  //}
}