package week2

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(31); 

  val a = new Rational(1, 2);System.out.println("""a  : week2.Rational = """ + $show(a ));$skip(8); val res$0 = 
  a.num;System.out.println("""res0: Int = """ + $show(res$0));$skip(8); val res$1 = 
  a.den;System.out.println("""res1: Int = """ + $show(res$1));$skip(31); 

  val b = new Rational(2, 3);System.out.println("""b  : week2.Rational = """ + $show(b ));$skip(10); val res$2 = 
  a add b;System.out.println("""res2: week2.Rational = """ + $show(res$2));$skip(10); val res$3 = 
  b sub a;System.out.println("""res3: week2.Rational = """ + $show(res$3));$skip(31); 

  val x = new Rational(1, 3);System.out.println("""x  : week2.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : week2.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : week2.Rational = """ + $show(z ));$skip(20); val res$4 = 

  x.sub(y).sub(z);System.out.println("""res4: week2.Rational = """ + $show(res$4));$skip(11); val res$5 = 
  y.add(y);System.out.println("""res5: week2.Rational = """ + $show(res$5));$skip(14); val res$6 = 

  y.less(x);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(11); val res$7 = 
  y.max(x);System.out.println("""res7: week2.Rational = """ + $show(res$7))}
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
