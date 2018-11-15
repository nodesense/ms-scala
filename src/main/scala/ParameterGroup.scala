object ParameterGroup extends  App {
  def add(a: Int, b: Int, c: Int) = a + b + c

  // parameter group
  def sum(a: Int)(b: Int)(c: Int) = a + b + c

  val sumPG = (a: Int) => { // return a function b
    (b: Int) => { // return function c
      (c: Int) => { // return sum of a + b + c Int
        a + b + c
      }
    }
  }

  val result: Int = add(10, 20, 30)
  println("add ", result);

  // sum10 is a partially applied function
  val sum10 = (sum _) (10);
  val sum10Plus5 = sum10(5)

  val sumPG10 = sumPG (10);
  val sumPG10Plus5 = sumPG10(5)
  val result4 = sumPG10Plus5(100);
  println("result 4", result4)


  val result2 = sum10Plus5(20)
  val result3 = sum10Plus5(100)

  println("result 2", result2)

  println("result 3", result3)

  def wrap(prefix: String)(html: String)(suffix: String) = {
    prefix + html + suffix
  }

  val hello = "Hello, world"
  val divHtml = wrap("<div>")(hello)("</div>")
  println(divHtml)

  val wrapWithDiv = wrap("<div>")(_: String)("</div>")

  println("Text", wrapWithDiv("Hello World"))
  println("Button", wrapWithDiv("<button>Hello World</button>"))


}
