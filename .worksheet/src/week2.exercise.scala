package week2

object exercise {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(114); 

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(30); val res$0 = 

  product(x => x + x)(1, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(92); 
  // 2 * 4 * 6 * 8 * 10 (product of sums)

  def fact(n: Int): Int = product(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(16); val res$1 = 
  
  
  fact(5);System.out.println("""res1: Int = """ + $show(res$1))}
  
  
  
  

}
