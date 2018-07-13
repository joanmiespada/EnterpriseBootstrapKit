import models._

import org.scalatest._

class UserSpec extends FlatSpec with Matchers {

  "A models.User" should "have an email" in {
    val email:String = "jojo@jaja.com"
    val user = new UserModel
    user.Email = email
    user.Email should be (email)
  }

  /*it should "empty password" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }*/
  //}
}