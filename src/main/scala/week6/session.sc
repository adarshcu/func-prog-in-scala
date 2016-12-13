package week6

//other collections & Combinatorial Search and For-Expressions

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //Vector -- Evenly balanced access pattern

  val sample = Array("a", "a", "a", "a", "a", "b", "b", "c", "a")
                                                  //> sample  : Array[String] = Array(a, a, a, a, a, b, b, c, a)

  sample map (x => x.toUpperCase())               //> res0: Array[String] = Array(A, A, A, A, A, B, B, C, A)
  //also works for strings
  val dummy = "Wtf? This is going to be very complex now... "
                                                  //> dummy  : String = "Wtf? This is going to be very complex now... "
  dummy filter (c => c.isUpper)                   //> res1: String = WT
  dummy exists (c => c.isUpper)                   //> res2: Boolean = true
  dummy forall (x => x.isUpper)                   //> res3: Boolean = false
  //range
  val myRange: Range = 1 to 100 by 3              //> myRange  : Range = Range(1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40
                                                  //| , 43, 46, 49, 52, 55, 58, 61, 64, 67, 70, 73, 76, 79, 82, 85, 88, 91, 94, 97
                                                  //| , 100)
  val myRange2: Range = 1 until 100 by 3          //> myRange2  : Range = Range(1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 4
                                                  //| 0, 43, 46, 49, 52, 55, 58, 61, 64, 67, 70, 73, 76, 79, 82, 85, 88, 91, 94, 9
                                                  //| 7)
  val zipper = sample zip dummy                   //> zipper  : Array[(String, Char)] = Array((a,W), (a,t), (a,f), (a,?), (a, ), (
                                                  //| b,T), (b,h), (c,i), (a,s))
  zipper.unzip                                    //> res4: (Array[String], Array[Char]) = (Array(a, a, a, a, a, b, b, c, a),Array
                                                  //| (W, t, f, ?,  , T, h, i, s))

  sample flatMap (c => c.toUpperCase())           //> res5: Array[Char] = Array(A, A, A, A, A, B, B, C, A)

  val xs = List[Double](1, 3, 6, -43, 7, 10)      //> xs  : List[Double] = List(1.0, 3.0, 6.0, -43.0, 7.0, 10.0)
  val zs = List[Double](1, 3, 6, -43, 7, 10)      //> zs  : List[Double] = List(1.0, 3.0, 6.0, -43.0, 7.0, 10.0)

  xs sum                                          //> res6: Double = -16.0

  def isPrime(n: Int): Boolean = {
    (2 until n) forall (d => n % d != 0)
  }                                               //> isPrime: (n: Int)Boolean

  isPrime(7)                                      //> res7: Boolean = true
  isPrime(9)                                      //> res8: Boolean = false

  val n = 7                                       //> n  : Int = 7
  val allPairs = (1 until n) map (i => (1 until i) map (j => (i, j)))
                                                  //> allPairs  : scala.collection.immutable.IndexedSeq[scala.collection.immutable
                                                  //| .IndexedSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1), (3,
                                                  //| 2)), Vector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), Vector
                                                  //| ((6,1), (6,2), (6,3), (6,4), (6,5)))

  val flattenedPairs = allPairs flatten           //> flattenedPairs  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector
                                                  //| ((2,1), (3,1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1)
                                                  //| , (6,2), (6,3), (6,4), (6,5))

  flattenedPairs filter (pair => isPrime(pair._1 + pair._2))
                                                  //> res9: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 2), (4,1), (4,3), (5,2), (6,1), (6,5))

  //same as above but uses for expressions to do the same thing
  for (i <- 1 until n; j <- 1 until n; if isPrime(i + j)) yield (i, j)
                                                  //> res10: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1
                                                  //| ,2), (1,4), (1,6), (2,1), (2,3), (2,5), (3,2), (3,4), (4,1), (4,3), (5,2), 
                                                  //| (5,6), (6,1), (6,5))

  // x1*y1 + x2*y2 + .... + xn*yn
  def scalarProduct(zs: List[Double], ys: List[Double]): Double = (for ((x, y) <- zs zip ys) yield x * y).sum
                                                  //> scalarProduct: (zs: List[Double], ys: List[Double])Double

  scalarProduct(xs, zs);                          //> res11: Double = 2044.0
}
//for (p <- persons if p.age > 20) yield p.name
case class Person(name: String, age: Int)