package week3

object overrides {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}

abstract class Base {
  def foo = 1
  def bar: Int
}
class Sub extends Base {
  override def foo = 2 // use of override mandatory in scala... unlike java
  def bar = 3
}