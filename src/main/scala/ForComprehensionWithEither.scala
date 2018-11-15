object ForComprehensionWithEither extends  App {

  case class User(id: Int);
  case class Failure(msg: String);

  def getUser(id: Int): Either[User, Failure] = {
    //Left(User(id))
    Right(Failure(s"User $id not found "))
  }

  def isEligible(user: User): Either[Boolean, Failure] = {

    println("isEligible called", user)
    // None
    Left(true)
  }

  def getTotal(): Either[Int, Failure] = {
    println("getTotal called")
    Left(1000)
  }

  def getDiscount(): Either[Int, Failure] = {
    println("getDiscount called")
    Left(20)
  }

  // Check with error.

  val result = for {
                    user <- getUser(1).left
                    eligible <- isEligible(user).left
                    total <- getTotal().left
                    discount <- getDiscount().left
                  } yield  total - (total * discount / 100.0)

//
  println("End Result ", result)

  if (result.isLeft) {
    println("We have result ", result.left.get)
  }


  if (result.isRight) {
    println("We have error ", result.right.get)
  }

}
