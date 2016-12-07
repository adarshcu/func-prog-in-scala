package week1

object session {

  def test(x: Boolean) = if (x) println("TRUE") else println("FALSE")
                                                  //> test: (x: Boolean)Unit

  test(true)                                      //> TRUE
  test(false)                                     //> FALSE

  def loop: Boolean = loop                        //> loop: => Boolean
  def and(x: Boolean, y: => Boolean): Boolean = if (x) y else false
                                                  //> and: (x: Boolean, y: => Boolean)Boolean

  //use call by name for second parameter because && is short circuit operator. should evaluate and(false,loop)

  println(and(true, false))                       //> false

  println(and(true, true))                        //> true

  println(and(false, loop))                       //> false

  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) = (guess + x / guess) / 2

    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double

  sqrt(4)                                         //> res0: Double = 2.000609756097561

  sqrt(1.0e60)                                    //> res1: Double = 1.0000788456669446E30

  sqrt(1.0e20)                                    //> res2: Double = 1.0000021484861237E10

  sqrt(0.001)                                     //> res3: Double = 0.03162278245070105

  sqrt(1e-20)                                     //> res4: Double = 1.0000021484861236E-10

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)       //> factorial: (n: Int)Int

  factorial(10)                                   //> res5: Int = 3628800

  def fact(n: Int): Int = {

    def myloop(acc: Int, n: Int): Int =
      if (n == 0) acc else myloop(acc * n, n - 1)

    myloop(1, n)
  }                                               //> fact: (n: Int)Int
  
  
  fact(10)                                        //> res6: Int = 3628800
}