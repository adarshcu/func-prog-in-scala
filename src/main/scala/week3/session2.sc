
object session2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  println("What the f is wrong here....")         //> What the f is wrong here....
  //imports are not working in scala worksheet

  val x = null;                                   //> x  : Null = null
  val y: String = x                               //> y  : String = null

  // ERROR val z: Int = x
}