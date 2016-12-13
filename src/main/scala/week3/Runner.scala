package week3

import week4.Nil

import week4.List

import week4.Cons

object Runner extends App {
  def nth[T](n: Int, xs: List[T]): T =
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)

  val lsit = new Cons(1, new Cons(2, new Cons(3, new Cons(78, Nil))))

  println(nth(2, lsit))
}
