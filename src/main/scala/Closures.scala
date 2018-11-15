// state management within function
object Closures extends  App {
  val Seq = (seed: Int, step: Int) => {
      var counter = seed

      val incr = () => {
        // expose visiblity of counter
        val result = counter
        counter = counter + step
        result
      }

    // return a function, that takes no argument, return int
     incr
  }

  // seq100 is a function

    var seq100 = Seq(100, 1);
    var seq1By2 = Seq(1, 2);


  //  println("Seq(100, 1)", Seq(100, 1));
    //println("Seq(100, 1)", Seq(100, 1));
//
  println("seq100", seq100())
    println("seq1By2", seq1By2())
    println("seq100", seq100())
    println("seq1By2", seq1By2())
    println("seq100", seq100())


}
