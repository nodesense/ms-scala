object DefAndLazy extends  App {

  // method, no input, return string

  def getName = "Scala"

  def power(n: Int) = n * n

  def add(a: Int, b: Int) = {
    println("Add", a, b)
    a + b
  }

  // for return statement, need explicit type
  def sub(a: Int, b: Int): Int = {
    println("Sub", a, b)
    return a - b;
  }

  println(getName)
  println(power(3))
  println(add(10, 20))
  println(sub(10, 20))

  def addOrSub(operation: String, a: Int, b: Int) = {
      lazy val subResult = sub(a, b)
      lazy val addResult = add(a, b)

      if (operation == "add") {
           addResult
      } else {
        subResult
      }
  }

  println("addOrSub", addOrSub("add", 1, 2) )
  println("addOrSub", addOrSub("sub", 1, 2) )

  // convert a method to function object
  val add2 = add _;

  println(add2.apply(10, 20))
}
