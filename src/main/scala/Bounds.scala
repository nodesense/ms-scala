object Bounds extends  App {

  case class Dimension (length: Int,
                        width: Int,
                        height: Int)

  class Vehicle(val dimension: Dimension) {

  }

  class Bycycle(dimension: Dimension) extends  Vehicle(dimension) {

  }

  class Car(dimension: Dimension) extends  Vehicle(dimension) {

  }

  class Parking[A <: Vehicle] {
    var vehicleInPark : A = _;
    def park(v: A) = vehicleInPark = v;
    def occupied = println(vehicleInPark.dimension)
  }

  val parking = new Parking[Car];
  parking.park(new Car(Dimension(5, 10, 5)))
  parking.occupied

  parking.park(null)



}
