object ListAdtRecursiveExample extends  App {

  def sum(list: List[Int]): Int =
    list match {
        // removing Nil or head :: tail cause warning
      case Nil     => 0
      case head :: tail => head + sum(tail)
    }

  println("Sum with nil ", sum(Nil))

  println("Sum with 1,2,3 ", sum(List(1,2,3)))

}
