object AdtExample extends  App {

  sealed trait Pet
  case class Cat(name: String) extends Pet
  case class Fish(name: String, color: String) extends Pet
  case class Squid(name: String, age: Int) extends Pet
  val bob: Pet = Cat("Bob")

  def sayHi(p: Pet): String =
    p match {
      case Cat(n)      => "Meow " + n + "!"
      case Fish(n, _)  => "Hello fishy " + n + "."
      case Squid(n, _) => "Hi " + n + "."
    }

  // sum type, excluding one type
  def sayHello(p: Pet): String =
    p match {
      case Cat(n)      => "Meow " + n + "!"
      case Squid(n, _) => "Hi " + n + "."
    }


  println(sayHi(Cat("Bob"))) // match to Cat(n)

  // sum type get warning
  // throws exception, since Fish is not implemented
  //println(sayHello(Fish("F1", "yellow")))

  sealed trait Direction
  case object North extends Direction
  case object South extends Direction
  case object East extends Direction
  case object West extends Direction

  def showDirection(d: Direction) =
    d match {
      case North       => "Going North"
      case South       => "Going South"
     // case West       => "Going West"
      case East       => "Going East"
    }


  println(showDirection(North))




}
