object ForYield extends App {

  for(i <- 1 to 5) {
    println(i)
  }

  val result = for (name <- List("Scala", "Java"))
    println(name)

  println("result ", result)

  val evens = for (i <- 1 to 10 if i % 2 == 0) yield i;
  println("evens", evens)

}
