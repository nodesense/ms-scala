// domain models

// Scala automatically shall generate class and companion object
// companion object includes apply and unapply

// id, amount is a member variable, of val type, public
// DO NOT USE var amount: Int
case class Order(id: Int,
                 amount: Int);

case class WholesaleOrder(id: Int,
                          amount: Int,
                          customerId: Int);

object OrderApp extends  App {

  def processOrder(order: Object) = {
    order match {
        // case with if guard
      case order: Order if order.amount >= 100000 => println("Highvolume transfer", order)
      case o:Order => println("Processing Order", o)
      case w:WholesaleOrder => println("Wholesale order", w)

      case _ => println("Unknown order")
    }
  }

  // calls Order.apply from companion object
  val order1 = Order(1, 1000);

  println("order 1", order1);
  processOrder(order1)

  // doesn't not call Order.apply
  val order2 = new Order(2, 2000);

  println("order 2", order2);
  processOrder(order2)

  processOrder(WholesaleOrder(1000, 100000, 1234));

  processOrder(Order(33, 1000000));

  val worder1 = WholesaleOrder(1000, 100000, 1234);

  // extractor pattern, deconstruct
  // shall call unapply function
  val WholesaleOrder(id, amount, customerId) = worder1

  println(id, amount, customerId)

}