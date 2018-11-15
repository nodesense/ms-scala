object CollectionExample  extends  App {

  val names= "iPhone" :: "Galaxy" :: "Nexus" :: Nil
  println("Names ", names)

  println("isEmpty ", names.isEmpty)

  println("Head", names.head)
  println("Tail", names.tail)

  val reversed = names.reverse
  println("reversed ", reversed)

  println("names ", names)


  case class Mobile(title: String, price: Int)
  val phones = Seq( Mobile("Moto", 15000),
    Mobile("iPhone", 40000),
    Mobile("Galaxy", 35000),
    Mobile("MI", 20000) )

  println("MaxBy ", phones.maxBy(phone => phone.price))
  println("MinBy ", phones.minBy(phone => phone.price))


  println("sorted ordering by desc", phones.sorted(Ordering.by((_: Mobile).price).reverse));

  println("sorted ordering by asc", phones.sorted(Ordering.by((_: Mobile).price)));

  println("Sort by desc", phones.sortBy(_.price)(Ordering[Int].reverse))
  println("Sort by asc", phones.sortBy(_.price)(Ordering[Int]))


  val results = phones.partition(phone => phone.price <=25000 );

  println(results._1); // phones < =25000
  println(results._2); // phones > 25000

  val numbers = List(1,2,3,4,5);

  val total = numbers.fold(0) ( (acc, n) => {
     println("fold ", acc, n)
    acc + n
  });

  println("Total ", total)


  val totalLeft = numbers.foldLeft(0) ( (acc, n) => {
    println("foldLeft ", acc, n)
    acc + n
  });


  println("Total Left ", totalLeft)

  val totalRight = numbers.foldRight(0) ( (n, acc) => {
    println("foldRight ", acc, n)
    acc + n
  });

  println("totalRight ", totalRight)

  val multi = numbers.fold(1) ( (acc, n) => acc * n);
  println("multi ", multi)

  val sum: Double = numbers.reduce(_ + _)
  println("Sum ", sum);
  val sum1: Double = numbers.reduce((a, b) => a + b)
  println("sum1 ", sum1);

  println("Reduce min ", numbers.reduce(_ min _))

  println("Reduce max ", numbers.reduce(_ max _))

  val findMax = (x: Int, y: Int) => {
    Thread.sleep(10)
    val winner = x max y
    println(s"compared $x to $y, $winner was larger")
    winner
  }

  val a = Array.range(0,50)
  println("reduce  ", a.par.reduce(findMax))
  println("reduce Left ", a.par.reduceLeft(findMax))
  println("reduce right  ", a.par.reduceRight(findMax))
}
