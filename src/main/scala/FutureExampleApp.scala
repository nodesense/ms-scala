// FutureExampleApp.scala

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object FutureExampleApp  extends  App {

  // task, executed by thread pool
  val future = Future {
    println("Executed in future")
    Thread.sleep(2000)
    // throw new Exception("Error")
    100 // return result
  }


  println("isCompleted", future.isCompleted)

//  while(!future.isCompleted) {
//    println("Waiting ")
//    Thread.sleep(100);
//  }
 // println("isCompleted", future.isCompleted)

  // block main thread
  val result = Await.result(future, 5 second)
  println("Result ", result)


  case class User(id: Int);

  def getUser(id: Int) = {
    Future {
      // call rest api/file system/db
      println("Get User Called")
      User(id)
      //throw new Error(s"User $id not found")
    }
  }

  def isEligible(user: User) = {
    Future {
      println("isEligible called", user)
      // None
      true
    }
  }

  def getTotal()  = {
    Future {
      println("getTotal called")
      1000
    }
  }

  def getDiscount()= {
    Future {
      println("getDiscount called")
      20
    }
  }

  // Check with error.

  val futureResult = for {
    user <- getUser(1)
    eligible <- isEligible(user)
    total <- getTotal()
    discount <- getDiscount()
  } yield  total - (total * discount / 100.0)

  println("Features with comprehention ", futureResult)
  val result2 = Await.result(futureResult, 5 second)

  println("Result ", result2)

  val allTasks = Future.sequence(List(getUser(1),
                                      getTotal(),
                                      getDiscount()))

  allTasks.onComplete {
    case Success(res) => println("Success: Combined result " + res)
    case Failure(ex)  => println("Ohhh Exception: " + ex.getMessage)
  }

  Await.ready(allTasks, 20.seconds)




}
