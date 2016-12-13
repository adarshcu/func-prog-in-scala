package week4

/*trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
  //new addns 
  def isVar: Boolean
  def isProd: Boolean 
}

class Number(n: Int) extends Expr {
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def isVar = false
  def isProd = false
  def numValue: Int = n
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOp")
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def isVar = false
  def isProd = false
  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
}

object runner {
  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("")
  }
}*/

/*trait Expr

case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Var(x: String) extends Expr

case class Product(e1: Expr, e2: Expr) extends Expr*/