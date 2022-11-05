package advent

import data.AdventData.puzzleInput

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    val ages = Seq(42, 75, 29, 64)
    println(s"The oldest person is ${ages.max}")

    val puzzleInputDigits = puzzleInput.map(_.asDigit)
    def isSummed(index: Int): Boolean = {
      puzzleInputDigits(index) == (puzzleInputDigits((index + 1) % puzzleInputDigits.length))
    }
    val sumList = puzzleInputDigits.zipWithIndex.flatMap { case (digit, index) => if (isSummed(index)) Some(digit) else None }.sum
    println(sumList)


  }
}
