package week3

//Class Hierarchies
object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val base = new NonEmpty(15, new Empty, new Empty)
                                                  //> base  : week3.NonEmpty = {.15.}

  val upd = base incl 4 incl 16                   //> upd  : week3.IntSet = {{.4.}15{.16.}}

  new Empty contains 1                            //> res0: Boolean = false

  upd contains 4                                  //> res1: Boolean = true

  upd contains 14                                 //> res2: Boolean = false

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