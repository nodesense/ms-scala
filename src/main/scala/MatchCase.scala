object MatchCase extends  App {
  // switch case eq match case.

  val result = 11 % 2 match {
    case 0 => "Even"
    case 1 => "Odd"
  }

  println(result)

  val result2 = 10 % 4 match {
    case 0 => {
      10 + 2
      10 * 2 // this value returned
    }
    case 1 => "Odd"

    // default
    case x =>  {
      println(x)
      "Unknown"
    }
  }

  println(result2)

  var result3 = for (i <- 1 to 10 ) yield {i % 2} match {
    case 1 => i
    case _ => ;
  }

  println("results3 ", result3)

}
