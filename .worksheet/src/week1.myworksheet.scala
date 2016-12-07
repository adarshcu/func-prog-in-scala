package week1

object myworksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  println("Welcome to the Scala worksheet");$skip(12); 
  val x = 1;System.out.println("""x  : Int = """ + $show(x ));$skip(31); 
  def increase(i: Int) = i + 1;System.out.println("""increase: (i: Int)Int""");$skip(22); 
  val b = increase(x);System.out.println("""b  : Int = """ + $show(b ));$skip(22); 
  val c = increase(b);System.out.println("""c  : Int = """ + $show(c ));$skip(16); 
  var d = c + 1;System.out.println("""d  : Int = """ + $show(d ))}
  
  
  ////////////////
  
  
}
