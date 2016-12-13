package week2

object rationals2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val a = new Rational2(1, 2)                     //> a  : week2#33.Rational2#268622 = 1/2
  a.num                                           //> res0: Int#1086 = 1
  a.den                                           //> res1: Int#1086 = 2

  val b = new Rational2(2, 3)                     //> b  : week2#33.Rational2#268622 = 2/3
  a + b                                           //> res2: week2#33.Rational2#268622 = 7/6
  b - a                                           //> res3: week2#33.Rational2#268622 = 1/6

  val x = new Rational2(1, 3)                     //> x  : week2#33.Rational2#268622 = 1/3
  val y = new Rational2(5, 7)                     //> y  : week2#33.Rational2#268622 = 5/7
  val z = new Rational2(3, 2)                     //> z  : week2#33.Rational2#268622 = 3/2

  x - y - z                                       //> res4: week2#33.Rational2#268622 = -79/42
  y + y                                           //> res5: week2#33.Rational2#268622 = 10/7

  y < x                                           //> res6: Boolean#2508 = false
  y max x                                         //> res7: week2#33.Rational2#268622 = 5/7
}

class Rational2(x: Int, y: Int) {
  //predefined function = takes a condition and throw illegal argument exception with message passed to the method
  require(y != 0, "divide by zero error check")
  //assert can also be used here.. assert is used to check code.. require is to enfore preconditions

  def this(x: Int) = this(x, 1) // second constructor -- this when used as a function name refers to a constructor

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  val num = x
  val den = y

  def +(that: Rational2) =
    new Rational2(this.num * that.den + that.num * this.den,
      this.den * that.den)

  override def toString = {
    this.num / this.gcd(num, den) + "/" + this.den / this.gcd(num, den)
  }
  def -(that: Rational2) = this + that.neg

  def neg: Rational2 = new Rational2(-this.num, this.den)

  def <(that: Rational2) = this.num * that.den < that.num * this.den

  def max(that: Rational2) = if (this < that) that else this

}