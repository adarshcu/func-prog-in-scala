package week5.sub2

//reduction of lists
object session2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //reduceLeft and foldLeft

  def sum(xs: List[Int]) = (0 :: xs) reduceLeft ((x, y) => x + y)
                                                  //> sum: (xs: List[Int])Int
  def product(xs: List[Int]) = (1 :: xs) reduceLeft (_ * _)
                                                  //> product: (xs: List[Int])Int

  def sum2(xs: List[Int]) = (xs foldLeft 0)(_ + _)//> sum2: (xs: List[Int])Int
  def product2(xs: List[Int]) = (xs foldLeft 1)(_ * _)
                                                  //> product2: (xs: List[Int])Int
  val xs = List[Int](-1, 3, 26, -43, 7, 10, 51, 123)
                                                  //> xs  : List[Int] = List(-1, 3, 26, -43, 7, 10, 51, 123)

  sum(xs)                                         //> res0: Int = 176
  sum2(xs)                                        //> res1: Int = 176

  product(xs)                                     //> res2: Int = 1472774940
  product2(xs)                                    //> res3: Int = 1472774940

  //foldRight and reduceRight

  def sumR(xs: List[Int]) = (0 :: xs) reduceRight (_ + _)
                                                  //> sumR: (xs: List[Int])Int
  def productR(xs: List[Int]) = (1 :: xs) reduceRight (_ * _)
                                                  //> productR: (xs: List[Int])Int

  def sumR2(xs: List[Int]) = (xs foldRight 0)(_ + _)
                                                  //> sumR2: (xs: List[Int])Int
  def productR2(xs: List[Int]) = (xs foldRight 1)(_ * _)
                                                  //> productR2: (xs: List[Int])Int
  sumR(xs)                                        //> res4: Int = 176
  sumR2(xs)                                       //> res5: Int = 176

  productR(xs)                                    //> res6: Int = 1472774940
  productR2(xs)                                   //> res7: Int = 1472774940

  def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys)(_ :: _)                     //> concat: [T](xs: List[T], ys: List[T])List[T]

  //TODO - Done now
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())((x, u) => f(x) :: u) //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  mapFun(xs, (x => x / 2): Int => Int)            //> res8: List[Int] = List(0, 1, 13, -21, 3, 5, 25, 61)

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)((_, count) => count + 1)     //> lengthFun: [T](xs: List[T])Int

  lengthFun(xs)                                   //> res9: Int = 8

}