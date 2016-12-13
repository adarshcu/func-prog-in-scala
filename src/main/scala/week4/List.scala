package week4

trait List[+T] {

  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](e: U): List[U] = new Cons(e, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}


abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def contains(x: Int): Boolean = false
  def union(other: IntSet) = other
  override def toString = "."
}

// an improvement can be made to Empty.. change it to singleton.
//change class Empty to object Empty and just use Empty instead of NonEmpty

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean =
    if (x < elem) left contains x // recursive call
    else if (x > elem) right contains x // recursive call
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right) // recursive call
    else if (x > elem) new NonEmpty(elem, left, right incl x) // recursive call
    else this

  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem

  override def toString = "{" + left + elem + right + "}";
}

object test {
  val x: List[String] = Nil
  //def f(xs: List[NonEmpty], x: Empty): List[IntSet]
  def f(xs: List[NonEmpty], x: Empty) = xs prepend x
}