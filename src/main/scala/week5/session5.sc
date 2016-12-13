package week5

object session5 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val xs = List[String]("1", "2", "3")            //> xs  : List[String] = List(1, 2, 3)
  xs(2)                                           //> res0: String = 3
  xs.init                                         //> res1: List[String] = List(1, 2)
  xs.drop(2)                                      //> res2: List[String] = List(3)
  xs.take(2)                                      //> res3: List[String] = List(1, 2)

  val ys = List[String]("4", "5", "6")            //> ys  : List[String] = List(4, 5, 6)

  xs ++ ys                                        //> res4: List[String] = List(1, 2, 3, 4, 5, 6)

  ys reverse 1                                    //> res5: String = 5
  xs.updated(2, "23")                             //> res6: List[String] = List(1, 2, 23)
  xs indexOf ("3")                                //> res7: Int = 2
  xs contains 3                                   //> res8: Boolean = false

  //custom init implementation
  def init[T](xs: List[T]): List[T] = xs match {
    case List()  => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List()  => ys
    case z :: zs => z :: concat(zs, ys)
  }                                               //> concat: [T](xs: List[T], ys: List[T])List[T]

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List()  => xs
    case x :: xs => reverse(xs) ++ List(x)
  }                                               //> reverse: [T](xs: List[T])List[T]

  def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
    case List()  => xs
    case x :: xs => if (n == 0) xs else x :: removeAt(n - 1, xs)
  }                                               //> removeAt: [T](n: Int, xs: List[T])List[T]

  removeAt(1, List('a', 'b', 'c', 'd'))           //> res9: List[Char] = List(a, c, d)

  def flatten(xs: List[Any]): List[Any] =
    xs match {
      case List() => List()
      case y :: ys => y match {
        case k :: ks => flatten(List(k)) ::: flatten(ks) ::: flatten(ys)
        case _       => y :: flatten(ys)
      }
    }                                             //> flatten: (xs: List[Any])List[Any]

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }                                               //> matchTest: (x: Int)String
  println(matchTest(3))                           //> many

  /// pairs and tuples

  val pair = ("answer", 123)                      //> pair  : (String, Int) = (answer,123)

  pair._1                                         //> res10: String = answer
  pair._2                                         //> res11: Int = 123

   println("Welcome to the Scala worksheet")      //> Welcome to the Scala worksheet

  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] =
        (xs, ys) match {
          case (Nil, ys)            => ys
          case (xs, Nil)            => xs
          case (x :: xs1, y :: ys1) => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
        }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }                                               //> msort: (xs: List[Int])List[Int]

  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  msort(nums)                                     //> res12: List[Int] = List(-4, 1, 2, 5, 7)

}