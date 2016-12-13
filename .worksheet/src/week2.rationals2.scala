package week2

object rationals2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(32); 

  val a = new Rational2(1, 2);System.out.println("""a  : week2#33.Rational2#268622 = """ + $show(a ));$skip(8); val res$0 = 
  a.num;System.out.println("""res0: Int#1086 = """ + $show(res$0));$skip(8); val res$1 = 
  a.den;System.out.println("""res1: Int#1086 = """ + $show(res$1));$skip(32); 

  val b = new Rational2(2, 3);System.out.println("""b  : week2#33.Rational2#268622 = """ + $show(b ));$skip(8); val res$2 = 
  a + b;System.out.println("""res2: week2#33.Rational2#268622 = """ + $show(res$2));$skip(8); val res$3 = 
  b - a;System.out.println("""res3: week2#33.Rational2#268622 = """ + $show(res$3));$skip(32); 

  val x = new Rational2(1, 3);System.out.println("""x  : week2#33.Rational2#268622 = """ + $show(x ));$skip(30); 
  val y = new Rational2(5, 7);System.out.println("""y  : week2#33.Rational2#268622 = """ + $show(y ));$skip(30); 
  val z = new Rational2(3, 2);System.out.println("""z  : week2#33.Rational2#268622 = """ + $show(z ));$skip(14); val res$4 = 

  x - y - z;System.out.println("""res4: week2#33.Rational2#268622 = """ + $show(res$4));$skip(8); val res$5 = 
  y + y;System.out.println("""res5: week2#33.Rational2#268622 = """ + $show(res$5));$skip(10); val res$6 = 

  y < x;System.out.println("""res6: Boolean#2508 = """ + $show(res$6));$skip(10); val res$7 = 
  y max x;System.out.println("""res7: week2#33.Rational2#268622 = """ + $show(res$7))}
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
