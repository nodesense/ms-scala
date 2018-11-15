package appliances;

object Light2 {
  def apply(n: String) = new Light(n)

  def show(l: Light) = {
    println(l.name)
  }
}
