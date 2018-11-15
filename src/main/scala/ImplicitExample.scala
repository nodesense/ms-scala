object ImplicitExample extends  App {
  def add(a:Int)(implicit b:Int) = a + b


  // implicit has scope
  def method1 = {
    // goes by Type, not variable name
    implicit val m: Int = 1
    // not allowed, we have implicit with Int already present
    //implicit val n : Int = 1


   // println(add(10)(15)) // explicit
    println(add(10)) // implicit, value 1 passed to func

    // getter to get value of implicity by type
    val v = implicitly[Int]
    println("V is ", v)
  }

  def method2 = {
    // goes by Type, not variable name
    implicit val m: Int = 100
    // not allowed, we have implicit with Int already present
    //implicit val n : Int = 1

   // println(add(10)(15)) // explicit
    println(add(10)) // implicit, value 1 passed to func
  }

  method1
  method2



  // Use with caution. may affect other user code
  implicit def doubleToInt(d: Double) = {
    println("doubleToInt automatically")
    d.toInt
  }

  val x: Int = 42.0



  case class Config(host: String, port: Int) {
    def prettyPrint(prefix: String, msg: String): String =
      List(prefix, ": ", msg, " on ", host, ":", port.toString).mkString
  }

  implicit val config = Config("example.com", 8080)

  private def doStuff(prefix: String, msg: String)
                     (implicit c: Config): String =
    c.prettyPrint(prefix, msg)

  println(doStuff("example.com", "www"))

  val c = implicitly[Config];
  println("using implicitly", c)


}
