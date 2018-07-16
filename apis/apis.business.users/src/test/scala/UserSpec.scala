import com.datastax.driver.core.Cluster
import data.UserData
import logic.UserLogic
import models._
import org.scalatest._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class UserSpec extends FlatSpec with Matchers {



  "A models.User" should "have an email and password" in {

    val cluster = {
      Cluster.builder()
        .addContactPoint("10.110.0.10")
        // .withCredentials("username", "password")
        .build()
    }

    val session = cluster.connect("test")

    val logic = new UserLogic( new UserData(session ) )

    val user = new UserModel("1234fwer", "pepe","jose","pepe@jose.com","asdfg1234")

    val statements ={

    }

    val res = logic.Create(user)

    res should be (true)

    Await.ready(statements, Duration.Inf)

    cluster.close()

  }

  /*it should "empty password" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }*/
  //}
}