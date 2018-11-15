// primary constructor
// make the constructor parameter to member var
// declare with var/val, by default public type
// private and protected
class Product(val name: String,
              protected var pPrice: Int,
              discount: Int ) {
  // entire body is class constructor

  // member variable, default public
  // can be prefixed with protected or private
  var amount: Double = 0;

  println("Product Created", name)

  //secondary cons
  def this() = {
    this("", 0, 0) // calling primary cons, must be first line
    println("Secondary cons")

  }

  def this(name: String, p: Int) = {
    this(name, p, 0) // primary constructor
  }

  //can't use val/var in secondary constructor
  // can't declare member variable in secondary cons
  def this(name: String) = {
    this(name, 0) // calls sccondary constructor this(name: String, p: Int)
  }

  // member method, public scope
  def calculate() = amount = pPrice - pPrice * discount / 100.0;


  // getter for pPrice, public
  def price: Int = pPrice;

  //setter for pPrice
  // "price_=" is a method, special to scala
  def price_= (value: Int) = {
    if (value >= 0) {
        pPrice = value;
    }
  }

//  // java specific setter
//  def setPrice(value: Int) = {
//    if (value >= 0) {
//      pPrice = value;
//    }
//  }

  // println("Product " + name + " " +  price)
  def showProductDetails = println(s"Product Details $name $price")

}


object Product {
  def apply() = new Product("", 0, 0)
  def apply(name: String) = new Product(name, 0, 0)

}

class MobileProduct(name: String,
                    p: Int,
                    discount: Int,
                    val display: String)
                        extends Product(name, p, discount ) {

  override def showProductDetails = println(s"MobileProduct Details $name $price $display")

}

// static portion in java, scala called as object
object Logger {
  // static member
  var level = "DEBUG";
  // static function in java
  def info(msg: String) = println(s"Info $msg")
}

// TODO
object FileLogger  {

  def info(msg: String) = println(s"Info $msg")
}


object ProductApp extends  App {
   val p1 = new Product("Nexus", 10000, 20);

  p1.calculate()
  println("Amount ", p1.amount)
  p1.showProductDetails

  // println(p1.name);
  // println(p1.pPrice) // protected

  // calls getter price
  println("Price ", p1.price);
  // calls setter
  p1.price = 20000;


  val p2 = new Product();
  val p3 = new Product("Moto");


  val p10 = Product();  // Product.apply()

  val p11 = Product("Moto");  // Product.apply("Moto")

  val p4 = new Product("iPhone", 20000)

  val mobile: MobileProduct = new MobileProduct("iPhone 10",
                                        30000,
                                20,
                                        "5 Inch");

  mobile.showProductDetails

  val mp: Product = mobile; // valid

  // downward casting, type casting
  val mp2 : MobileProduct = mp.asInstanceOf[MobileProduct];

  // true
  println("is p1 a Type of Product ", p1.getClass == classOf[Product])

  // false
  println("is mobile a Type of Product ", mobile.getClass == classOf[Product])

  println(p1.isInstanceOf[Product]); // true
  println(mobile.isInstanceOf[Product])// true
  println(mobile.isInstanceOf[MobileProduct]); // true

  Logger.info("Object created")

}
