object Sqrt extends  App {

  val sqrt:PartialFunction[Double, Double] = {
    //case d:Double if d > 0 => Math.sqrt(d)

    case d:Double if d > 0 => Math.sqrt(d)

    case d:Double if d == 0 => 0
  }

  println(sqrt(4))

  println(sqrt(0))

  println(sqrt(-2))
}
