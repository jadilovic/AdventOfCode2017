package advent

import data.AdventData.puzzleInput

object InverseCaptcha {

  def run(): Unit = {

    val puzzleInputDigits = puzzleInput.map(_.asDigit)

    def isSummed(index: Int): Boolean = {
      puzzleInputDigits(index) == (puzzleInputDigits((index + 1) % puzzleInputDigits.length))
    }

    val sumList = puzzleInputDigits.zipWithIndex.flatMap { case (digit, index) => if (isSummed(index)) Some(digit) else None }.sum

    println("Inverse Captcha 1/2")
    println(s"Sum of all digits that match the next digit in the list is ${sumList}")

  }
}
