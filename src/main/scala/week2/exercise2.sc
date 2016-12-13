package week2

import math.abs
object exercise2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, unit: Int)(a: Int, b: Int): Int =
    if (a > b) unit
    else combine(f(a), mapReduce(f, combine, unit)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, unit: Int)(a: Int, b:
                                                  //|  Int)Int

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  //calculate product from 1 to n = fact
  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int

  def sumOfProducts(n: Int) = product(x => x + x)(1, n)
                                                  //> sumOfProducts: (n: Int)Int
  fact(5)                                         //> res0: Int = 120
  sumOfProducts(5)                                //> res1: Int = 3840

  def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
                                                  //> sum: (f: Int => Int)(a: Int, b: Int)Int

  def productOfSums(n: Int) = product(x => x * x)(1, n)
                                                  //> productOfSums: (n: Int)Int

  productOfSums(5)                                //> res2: Int = 14400

  /// finding the fixed point of a function

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double

  fixedPoint(x => 2 + x / 2)(1)                   //> res3: Double = 3.99853515625

  def sqrt(x: Double) = fixedPoint(avgStbl(y => x / y))(1)
                                                  //> sqrt: (x: Double)Double
  def avgStbl(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> avgStbl: (f: Double => Double)(x: Double)Double
  sqrt(4)                                         //> res4: Double = 2.000000000000002
}