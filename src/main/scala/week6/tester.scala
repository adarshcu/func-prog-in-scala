package week6

object tester extends App {

  val fruits = Set("Apple", "banana", "Mango", "Pineapple");

  println(fruits filter (_.startsWith("App")))

  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] =
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens
    placeQueens(n)
  }

  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val queenWRows = (row - 1 to 0 by -1) zip queens
    queenWRows forall {
      case (r, c) => col != c && math.abs(col - c) != row - r
    }
  }

  println(queens(4))
  println(queens(8))

  println(queens(8) take 3)

  //Maps 

  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern") withDefaultValue "Garbage"
  //NoSuchElementException if not present.. hence use get or supply with Default Value like above
  println(capitalOfCountry("US"))
  println(capitalOfCountry("Bharat"))
  val fruit = List("Apple", "banana", "Mango", "Pineapple");

  println(fruit sortWith (_.length < _.length))

  println(fruit.sorted)

  println(fruit groupBy (_.head))
}