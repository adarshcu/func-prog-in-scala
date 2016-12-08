package week1

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(104); 

  def test(x: Boolean) = if (x) println("TRUE") else println("FALSE");System.out.println("""test: (x: Boolean)Unit""");$skip(15); 

  test(true);$skip(14); 
  test(false);$skip(29); 

  def loop: Boolean = loop;System.out.println("""loop: => Boolean""");$skip(68); 
  def and(x: Boolean, y: => Boolean): Boolean = if (x) y else false;System.out.println("""and: (x: Boolean, y: => Boolean)Boolean""");$skip(144); 

  //use call by name for second parameter because && is short circuit operator. should evaluate and(false,loop)

  println(and(true, false));$skip(29); 

  println(and(true, true));$skip(30); 

  println(and(false, loop));$skip(46); 

  def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(309); 

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) = (guess + x / guess) / 2

    sqrtIter(1.0)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(12); val res$0 = 

  sqrt(4);System.out.println("""res0: Double = """ + $show(res$0));$skip(17); val res$1 = 

  sqrt(1.0e60);System.out.println("""res1: Double = """ + $show(res$1));$skip(17); val res$2 = 

  sqrt(1.0e20);System.out.println("""res2: Double = """ + $show(res$2));$skip(16); val res$3 = 

  sqrt(0.001);System.out.println("""res3: Double = """ + $show(res$3));$skip(16); val res$4 = 

  sqrt(1e-20);System.out.println("""res4: Double = """ + $show(res$4));$skip(77); 

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1);System.out.println("""factorial: (n: Int)Int""");$skip(18); val res$5 = 

  factorial(10);System.out.println("""res5: Int = """ + $show(res$5));$skip(145); 

  def fact(n: Int): Int = {

    def myloop(acc: Int, n: Int): Int =
      if (n == 0) acc else myloop(acc * n, n - 1)

    myloop(1, n)
  };System.out.println("""fact: (n: Int)Int""");$skip(17); val res$6 = 
  
  
  fact(10);System.out.println("""res6: Int = """ + $show(res$6))}
}
