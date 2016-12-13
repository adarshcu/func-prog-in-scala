package week5.sub2

//higher order list functions
object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def squareList(xs: List[Int]): List[Int] =
    xs match {
      case Nil     => xs
      case y :: ys => y * y :: squareList(ys)
    }                                             //> squareList: (xs: List[Int])List[Int]

  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareList2: (xs: List[Int])List[Int]

  val xs = List[Int](1, 3, 6, -43, 7, 10)         //> xs  : List[Int] = List(1, 3, 6, -43, 7, 10)
  squareList(xs)                                  //> res0: List[Int] = List(1, 9, 36, 1849, 49, 100)
  squareList2(xs)                                 //> res1: List[Int] = List(1, 9, 36, 1849, 49, 100)

  def posElems(xs: List[Int]): List[Int] = xs filter (x => x > 0)
                                                  //> posElems: (xs: List[Int])List[Int]
  posElems(xs)                                    //> res2: List[Int] = List(1, 3, 6, 7, 10)

  //other variations of filtering
  xs filterNot (x => x > 0)                       //> res3: List[Int] = List(-43)
  xs partition (x => x > 0)                       //> res4: (List[Int], List[Int]) = (List(1, 3, 6, 7, 10),List(-43))
  xs takeWhile (x => x > 0)                       //> res5: List[Int] = List(1, 3, 6)
  xs dropWhile (x => x > 0)                       //> res6: List[Int] = List(-43, 7, 10)
  xs span (x => x > 0)                            //> res7: (List[Int], List[Int]) = (List(1, 3, 6),List(-43, 7, 10))

  val sample = List("a", "a", "a", "a", "a", "b", "b", "c", "a")
                                                  //> sample  : List[String] = List(a, a, a, a, a, b, b, c, a)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (fir, scnd) = xs span { y => x == y }
      fir :: pack(scnd)
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  pack(sample)                                    //> res8: List[List[String]] = List(List(a, a, a, a, a), List(b, b), List(c), Li
                                                  //| st(a))
  def encode[T](xs: List[T]): List[(T, Int)] = pack(xs) map (ys => (ys.head, ys.length))
                                                  //> encode: [T](xs: List[T])List[(T, Int)]
  encode(sample)                                  //> res9: List[(String, Int)] = List((a,5), (b,2), (c,1), (a,1))
}