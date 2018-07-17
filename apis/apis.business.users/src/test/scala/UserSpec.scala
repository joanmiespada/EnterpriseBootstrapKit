package test

import java.util.UUID
import com.outworkers.phantom.dsl._
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import logic.UserLogic
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

  def randomUser(): UserModel = {

    val lorem:Lorem = LoremIpsum.getInstance()
    val pass = "pepe".md5

    val res:UserModel =  new UserModel( UUID.randomUUID(), Option( lorem.getFirstName() ),Option( lorem.getName() ),
          pass, lorem.getEmail() ,DateTime.now())
    res
  }

 test("Create new random user data in database"){

    val user1 = randomUser()
    val future = UserLogic.Create( user1 )
    future map {r=>r shouldBe true }

  }

  /*it should "empty password" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }*/
  //}
}