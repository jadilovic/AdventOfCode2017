package advent

import data.AdventData.randomNumbersSpreadSheet

object CorruptionChecksum {

  def run(): Unit = {

    val randomNumbersTable = randomNumbersSpreadSheet.split("\n").map { row => row.split("\t").map(_.toInt)}.toSeq
    val checkSum: Int = randomNumbersTable.map { row => row.max - row.min }.sum

    println("DAY 2 - 2. Corruption Checksum 1/2")
    println(s"For each row, determine the difference between the largest value and the smallest value; the checksum is the sum of all of these differences ${checkSum}")
    println("")

    val sumEvenlyDivisible = randomNumbersTable.zipWithIndex.flatMap { case (row, i) =>
      row.zipWithIndex.map { case (item, index) =>
        for (i <- row.indices if item % row(i) == 0 && index != i) yield {
          item / row(i)
        }
      }.filter(item => item.nonEmpty).head
    }.sum

   // val sumEvenlyDivisible = for ((row, index) <- randomNumbersTable.zipWithIndex) yield { for ((item, i) <- row.zipWithIndex if item % row(i) == 0 && index != i) yield item / row(i)}

    println("DAY 2 - 2. Corruption Checksum 2/2")
    println(s"Find the only two numbers in each row where one evenly divides the other and add up each row's result ${sumEvenlyDivisible}")
    println("")
  }
}
