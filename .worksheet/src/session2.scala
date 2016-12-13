
object session2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(44); 

  println("What the f is wrong here....");$skip(65); 
  //imports are not working in scala worksheet

  val x = null;System.out.println("""x  : Null = """ + $show(x ));$skip(20); ;
  val y: String = x;System.out.println("""y  : String = """ + $show(y ))}

  // ERROR val z: Int = x
}
