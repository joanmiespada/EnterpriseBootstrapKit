import java.util.UUID

import data.entity.User
import org.joda.time.DateTime

class UserSpec extends CassandraSpec {

  override def beforeAll(): Unit = {
    super.beforeAll()
  }

  override def afterAll(): Unit = {
    super.afterAll()
  }


  "A User" should "stored in cassandra" in {

    //val user = new UserModel("1234fer" + n.toString , "pepe","jose","pepe@jose.com","asdfg1234")

    val future = this.database.store( User( UUID.randomUUID(), Option("name"),Option("surname"),"password","email",DateTime.now()))

    whenReady(future){ result=>
      result isExhausted() shouldBe true

    }
    //val logic = new UserLogic( new UserData(session ) )
    //val data = new UserData(session )

    //val user = new UserModel("1234fwer", "pepe","jose","pepe@jose.com","asdfg1234")




    //val res = logic.Create(user)

    //res should be (true)

    //Await.result(statements, Duration.Inf)

    //cluster.close()

  }

  /*it should "empty password" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }*/
  //}
}