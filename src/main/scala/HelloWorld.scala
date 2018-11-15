package appliances;

object HelloWorld extends App {
    var i: Int = 10;
    var k = 100

    val PI = 3.14;


    println("Hello Scala", i, k , PI, args.mkString(","))


    val l1 = Light2("Light 1");
    Light.show(l1)
    //println(l1.name)
}
