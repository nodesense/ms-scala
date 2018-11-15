object Functions extends App {
  // no return
  val printName = new Function0[Unit] {
    def apply = println("hello scala")
  }

  // last type is return value
   val getName = new Function0[String] {
      def apply = "Hello Scala"
   }

  val power = new Function1[Int, Int] {
    def apply(n: Int): Int = {
       n * n
    }
  }


  // sugar, Function1[Int, Int]
  val pow = (n: Int) => n * n;

  // type inference
  val pow4 = pow;

  val pow2:Function1[Int, Int] = pow;

  // sugar syntax
  var pow3: (Int => Int) = pow;

  // explicit return type, (take two inputs, return Int value)

  var add: (Int, Int) => Int = (a, b) => a + b

  var add2:Function2[Int, Int, Int] = add;

  println(getName); // note, no ()

  // sugar, internally it calls getName.apply()
  println(getName())

  println(getName.apply());

  println(power(10))

  println(pow(5))
  println(pow.apply(10))

  println(add(10, 20))

}
