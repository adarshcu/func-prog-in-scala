package week2

import math.abs
object exercise2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
  println("Welcome to the Scala worksheet");$skip(177); 

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, unit: Int)(a: Int, b: Int): Int =
    if (a > b) unit
    else combine(f(a), mapReduce(f, combine, unit)(a + 1, b));System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, unit: Int)(a: Int, b: Int)Int""");$skip(93); 

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(84); 
  //calculate product from 1 to n = fact
  def fact(n: Int) = product(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(58); 

  def sumOfProducts(n: Int) = product(x => x + x)(1, n);System.out.println("""sumOfProducts: (n: Int)Int""");$skip(10); val res$0 = 
  fact(5);System.out.println("""res0: Int = """ + $show(res$0));$skip(19); val res$1 = 
  sumOfProducts(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(89); 

  def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b);System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(58); 

  def productOfSums(n: Int) = product(x => x * x)(1, n);System.out.println("""productOfSums: (n: Int)Int""");$skip(21); val res$2 = 

  productOfSums(5);System.out.println("""res2: Int = """ + $show(res$2));$skip(73); 

  /// finding the fixed point of a function

  val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(81); 
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(233); 
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  };System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(34); val res$3 = 

  fixedPoint(x => 2 + x / 2)(1);System.out.println("""res3: Double = """ + $show(res$3));$skip(61); 

  def sqrt(x: Double) = fixedPoint(avgStbl(y => x / y))(1);System.out.println("""sqrt: (x: Double)Double""");$skip(63); 
  def avgStbl(f: Double => Double)(x: Double) = (x + f(x)) / 2;System.out.println("""avgStbl: (f: Double => Double)(x: Double)Double""");$skip(10); val res$4 = 
  sqrt(4);System.out.println("""res4: Double = """ + $show(res$4))}
}
