object CallByName  extends  App {
  // call by value

  def nanoTime() = {
    println("NanoTime called");
    System.currentTimeMillis()
  }

  def printTime(t: Long): Unit = {
    println("print Time");
    println("Time is ", t);
  }

  // call by value
  // step 1: call nanoTime, return milli seconds
  // step 2: call printTime with milli seconds
  printTime(nanoTime)
  printTime(nanoTime())
  println("----------")


  def printTimeByName(t: => Long): Unit = {
    println("print Time");
    println("Time is ", t);

  }



  // step 1: {nanoTime} code block is passed to printTimeByName
  // step 2: codeBlock is executed whenever it is used
  printTimeByName(nanoTime)

  printTimeByName({
    println("now by code block")
    100
  })

  def ifOrElse(cond: => Boolean,
               truePart: => Unit,
               elsePart: => Unit): Unit = {
    println("ifOrElse called")
    if (cond) {
      truePart
    } else {
      elsePart
    }
  }

  ifOrElse(true, println("True"), println("Else"));

  // function
  val rand =  ()  => {
    println("rand called")
    import scala.util.Random
    val r = new Random()
    val k = r.nextInt(100);
    println("k is ", k)
    k % 2 == 0
  }

  ifOrElse(rand(), println("True"), println("Else"));

  ifOrElse( {
    10 % 2 == 0
  }, {
    println("True")
    println("second line")
  }, println("Else"));


  // TODO: investigate sugar for call by name

}
