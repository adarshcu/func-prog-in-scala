package week6

class Poly(terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)
  val terms = terms0 withDefaultValue 0.0
  def +(other: Poly) = new Poly(terms ++ (other.terms map adjust))
  def adjust(term: (Int, Double)): (Int, Double) = {
    val (exp, coeff) = term
    exp -> (coeff + terms(exp))
  }
  override def toString =
    (for ((exp, coeff) <- terms.toList.sorted.reverse)
      yield coeff + "x ^ " + exp) mkString " + "
  def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
    val (exp, coeff) = term
    terms + (exp -> (coeff + terms(exp)))
  }
  def add(other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
}

object Super extends App {
  val p1 = new Poly(1 -> 2, 3 -> 4, 5 -> 6.2)
  val p2 = new Poly(0 -> 3, 3 -> 7)

  println(p1 + p2)
  println(p1 add p2) //foldLeft is better because it avoids creating the intermediate data structure

  println(p1.terms(7))
}