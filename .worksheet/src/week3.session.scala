package week3

//Class Hierarchies
object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(96); 
  println("Welcome to the Scala worksheet");$skip(54); 

  val base = new NonEmpty(15, new Empty, new Empty);System.out.println("""base  : week3.NonEmpty = """ + $show(base ));$skip(34); 

  val upd = base incl 4 incl 16;System.out.println("""upd  : week3.IntSet = """ + $show(upd ));$skip(25); val res$0 = 

  new Empty contains 1;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(19); val res$1 = 

  upd contains 4;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(20); val res$2 = 

  upd contains 14;System.out.println("""res2: Boolean = """ + $show(res$2))}

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
