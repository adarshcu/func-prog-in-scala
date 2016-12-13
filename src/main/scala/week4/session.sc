package week4

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  Sum(Number(2), Number(44))                      //> res0: week4.Sum = Sum(Number(2),Number(44))
  //Sum(Product(2, Var("x")), Var("y")))
  def show(e: Expr): String = e match {
    case Number(n) => n.toString()
    case Sum(l, r) => show(l) + "+" + show(r)
    case Var(x)    => x
    case Product(e1, e2) => if (e1.isInstanceOf[Sum]) "(" + show(e1) + ")" + "*" + show(e2)
    else if (e2.isInstanceOf[Sum]) show(e1) + "*" + "(" + show(e2) + ")"
    else show(e1) + "*" + show(e2)
  }                                               //> show: (e: week4.Expr)String
  show(Sum(Number(1), Number(2)))                 //> res1: String = 1+2

  show(Sum(Product(Number(2), Var("x")), Var("y")))
                                                  //> res2: String = 2*x+y
  show(Product(Sum(Number(2), Var("x")), Var("y")))
                                                  //> res3: String = (2+x)*y
}

trait Expr

case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Var(x: String) extends Expr

case class Product(e1: Expr, e2: Expr) extends Expr