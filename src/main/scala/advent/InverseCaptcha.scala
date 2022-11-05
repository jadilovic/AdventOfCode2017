package advent

import data.AdventData.puzzleInput

object InverseCaptcha {

  def run(): Unit = {

    val puzzleInputDigits = puzzleInput.map(_.asDigit)
    def isSummed(index: Int, offset: Int): Boolean = puzzleInputDigits(index) == puzzleInputDigits((index + offset) % puzzleInputDigits.length)
    val sumList = puzzleInputDigits.zipWithIndex.flatMap { case (digit, index) => if (isSummed(index, 1)) Some(digit) else None }.sum

    println("DAY 1 - Inverse Captcha 1/2")
    println(s"Sum of all digits that match the next digit in the list is ${sumList}")
    println("")

    val offset = puzzleInput.length / 2
    // val sumListHalf = (for ((digit, index) <- puzzleInputDigits.zipWithIndex if isSummed(index, offset)) yield digit).sum
    val sumListOffset = puzzleInputDigits.zipWithIndex.flatMap { case (digit, index) => if (isSummed(index, offset)) Some(digit) else None }.sum

    println("DAY 1 - Inverse Captcha 2/2")
    println(s"Sum of all digits that match the halfway around digit in the list is ${sumListOffset}")
    println("")
  }
}
