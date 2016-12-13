package week2

object rational {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(34); 

  println(new IrRational(1, 2))}
}

class IrRational(x: Int, y: Int) {
  def num = x
  def den = y
}
