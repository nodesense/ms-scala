package appliances

// TODO: check is sealed applied for companion

class Light(  val name: String) {

}


object Light {
  def apply(n: String) = new Light(n)

  def show(l: Light) = {
    println(l.name)
  }
}