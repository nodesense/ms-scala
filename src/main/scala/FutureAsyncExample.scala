
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}


object FutureAsyncExample extends  App {
  val future = Future {
    Thread.sleep(500)
    100
    //throw new Error("Connection error")
  }

  future.onComplete {
    case Success(value) => println("yay!", value)
    case Failure(exception) => println("On no!", exception)
  }

  Thread.sleep(10000);
}
