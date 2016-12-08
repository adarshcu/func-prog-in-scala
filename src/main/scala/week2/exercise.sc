package week2

object exercise {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x + x)(1, 5)                       //> res0: Int = 3840
  // 2 * 4 * 6 * 8 * 10 (product of sums)

  def fact(n: Int): Int = product(x => x)(1, n)   //> fact: (n: Int)Int
  
  
  fact(5)                                         //> res1: Int = 120
  
  
  
  

}