object Tuple extends  App {
  var t1 = (10, 20, "Scala")
  var t2 = 10 -> 20; // two member tuple _1, _2

  println(t1._1)

  println(t1._2)

  println(t1._1)

  // println(t1._4) // compile time error

  val (n1, _, _) = t1;

  println(n1)

  // order id, amount, using tuple
  val list = List(
    (1, 1000),
    2 -> 2000,
    (3, 3000)
  )

  println(list.filter( t => t._2 >= 2000))

//  println(
//    list.fi filter {case (id: Int, amount: Int) =>  amount >= 2000 }
//  )

}
