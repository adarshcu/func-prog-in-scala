package week2

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  /////// HIGHER ORDER FUNCTIONS = START
  def sums(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sums(f, a + 1, b)
  }                                               //> sums: (f: Int => Int, a: Int, b: Int)Int

  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int
  def sum(x: Int): Int = x                        //> sum: (x: Int)Int

  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1)
                                                  //> fact: (x: Int)Int

  sums(sum, 1, 10)                                //> res0: Int = 55
  sums(cube, 1, 2)                                //> res1: Int = 9
  sums(fact, 1, 10)                               //> res2: Int = 4037913
  /////// HIGHER ORDER FUNCTIONS = END
  fact(5)                                         //> res3: Int = 120

  ///ANON FUNCTIONS
  //f: Int => Int syntax is followed here
  sums((x: Int) => x * x * x, 1, 10)              //> res4: Int = 3025
  //type is not mandatory if it can be inferred
  sums((x) => x * x * x, 1, 10)                   //> res5: Int = 3025

  //tail recursive way - no stack overflows
  def sumTR(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }                                               //> sumTR: (f: Int => Int)(a: Int, b: Int)Int

  sumTR(sum)(1, 10)                               //> res6: Int = 55

  //currying syntax actually present in the above TR version of sum
  // but currying essentially returns a function
  // Takes as input a function, eg - cube and applies the summation function to it and returns a sum of Cubes function
  def sumCurry(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sumCurry: (f: Int => Int)(Int, Int) => Int

  sumCurry(cube)(1, 10)                           //> res7: Int = 3025

  //Upgrading the curry function with a new syntax
  // def sumCurry(f: Int => Int): (Int, Int) => Int = {
  //to
  //def sumCurry(f: Int => Int)(a: Int, b: Int): Int = {
}