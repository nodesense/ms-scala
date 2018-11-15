object IfExpr {
  def main(args: Array[String]): Unit = {
    println("welcome", args.mkString(":"));

    val result = if (10 % 2 == 1) "even" else "odd"

    val result2 = if (true) {
         println("welcome");
         10 + 20
         300 / 5 // to be last expression, assigned to result2
    } else 0

    println(result)
    println(result2)

  }
}
