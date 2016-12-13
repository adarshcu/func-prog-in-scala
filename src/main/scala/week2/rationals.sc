package week2

object rationals {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val a = new Rational(1, 2)                      //> a  : week2.Rational = 1/2
  a.num                                           //> res0: Int = 1
  a.den                                           //> res1: Int = 2

  val b = new Rational(2, 3)                      //> b  : week2.Rational = 2/3
  a add b                                         //> res2: week2.Rational = 7/6
  b sub a                                         //> res3: week2.Rational = 1/6

  val x = new Rational(1, 3)                      //> x  : week2.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : week2.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : week2.Rational = 3/2

  x.sub(y).sub(z)                                 //> res4: week2.Rational = -79/42
  y.add(y)                                        //> res5: week2.Rational = 10/7

  y.less(x)                                       //> res6: Boolean = false
  y.max(x)                                        //> res7: week2.Rational = 5/7
}

class Rational(x: Int, y: Int) {
  //predefined function = takes a condition and throw illegal argument exception with message passed to the method
  require(y != 0, "divide by zero error check")
  //assert can also be used here.. assert is used to check code.. require is to enfore preconditions

  def this(x: Int) = this(x, 1) // second constructor -- this when used as a function name refers to a constructor

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  val num = x
  val den = y

  def add(that: Rational) =
    new Rational(this.num * that.den + that.num * this.den,
      this.den * that.den)

  override def toString = {
    this.num / this.gcd(num, den) + "/" + this.den / this.gcd(num, den)
  }
  def sub(that: Rational) = add(that.neg)

  def neg: Rational = new Rational(-this.num, this.den)

  def less(that: Rational) = this.num * that.den < that.num * this.den

  def max(that: Rational) = if (this.less(that)) that else this

}