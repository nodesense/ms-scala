
class Stack[A] {
    var elems: List[A]    =    Nil
    def push(x: A) = { elems    =    x    ::    elems    }
    def top:    A    =    elems.head
    def pop()    {    elems    =    elems.tail    }
    def isEmpty = elems.isEmpty
}

object StackApp extends  App {
  case class Student(name: String)

  val stack = new Stack[Student];
  stack.push(Student("Stu 1"));

  val s: Student = stack.top;

  val stackofAny = new Stack[Any];


}