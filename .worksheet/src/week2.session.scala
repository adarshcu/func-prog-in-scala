package week2

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet");$skip(149); 

  /////// HIGHER ORDER FUNCTIONS = START
  def sums(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sums(f, a + 1, b)
  };System.out.println("""sums: (f: Int => Int, a: Int, b: Int)Int""");$skip(38); 

  def cube(x: Int): Int = x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(27); 
  def sum(x: Int): Int = x;System.out.println("""sum: (x: Int)Int""");$skip(63); 

  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1);System.out.println("""fact: (x: Int)Int""");$skip(21); val res$0 = 

  sums(sum, 1, 10);System.out.println("""res0: Int = """ + $show(res$0));$skip(19); val res$1 = 
  sums(cube, 1, 2);System.out.println("""res1: Int = """ + $show(res$1));$skip(20); val res$2 = 
  sums(fact, 1, 10);System.out.println("""res2: Int = """ + $show(res$2));$skip(49); val res$3 = 
  /////// HIGHER ORDER FUNCTIONS = END
  fact(5);System.out.println("""res3: Int = """ + $show(res$3));$skip(101); val res$4 = 

  ///ANON FUNCTIONS
  //f: Int => Int syntax is followed here
  sums((x: Int) => x * x * x, 1, 10);System.out.println("""res4: Int = """ + $show(res$4));$skip(80); val res$5 = 
  //type is not mandatory if it can be inferred
  sums((x) => x * x * x, 1, 10);System.out.println("""res5: Int = """ + $show(res$5));$skip(219); 

  //tail recursive way - no stack overflows
  def sumTR(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  };System.out.println("""sumTR: (f: Int => Int)(a: Int, b: Int)Int""");$skip(22); val res$6 = 

  sumTR(sum)(1, 10);System.out.println("""res6: Int = """ + $show(res$6));$skip(392); 

  //currying syntax actually present in the above TR version of sum
  // but currying essentially returns a function
  // Takes as input a function, eg - cube and applies the summation function to it and returns a sum of Cubes function
  def sumCurry(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  };System.out.println("""sumCurry: (f: Int => Int)(Int, Int) => Int""");$skip(26); val res$7 = 

  sumCurry(cube)(1, 10);System.out.println("""res7: Int = """ + $show(res$7))}

  //Upgrading the curry function with a new syntax
  // def sumCurry(f: Int => Int): (Int, Int) => Int = {
  //to
  //def sumCurry(f: Int => Int)(a: Int, b: Int): Int = {
}
