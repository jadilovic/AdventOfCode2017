package advent

import data.AdventData.randomNumbersSpreadSheet

object CorruptionChecksum {

  def run(): Unit = {

    val randomNumbersTable: Seq[List[String]] = Seq(randomNumbersSpreadSheet.split("\n")(0).split("\t").toList, randomNumbersSpreadSheet.split("\n")(1).split("\t").toList, randomNumbersSpreadSheet.split("\n")(2).split("\t").toList, randomNumbersSpreadSheet.split("\n")(3).split("\t").toList, randomNumbersSpreadSheet.split("\n")(4).split("\t").toList, randomNumbersSpreadSheet.split("\n")(5).split("\t").toList, randomNumbersSpreadSheet.split("\n")(6).split("\t").toList, randomNumbersSpreadSheet.split("\n")(7).split("\t").toList, randomNumbersSpreadSheet.split("\n")(8).split("\t").toList, randomNumbersSpreadSheet.split("\n")(9).split("\t").toList, randomNumbersSpreadSheet.split("\n")(10).split("\t").toList, randomNumbersSpreadSheet.split("\n")(11).split("\t").toList, randomNumbersSpreadSheet.split("\n")(12).split("\t").toList, randomNumbersSpreadSheet.split("\n")(13).split("\t").toList, randomNumbersSpreadSheet.split("\n")(14).split("\t").toList, randomNumbersSpreadSheet.split("\n")(15).split("\t").toList)
    val checkSum: Int = randomNumbersTable.map { row => row.map(_.toInt).max - row.map(_.toInt).min }.sum

    println("DAY 2 - Corruption Checksum 1/2")
    println(s"For each row, determine the difference between the largest value and the smallest value; the checksum is the sum of all of these differences ${checkSum}")
    println("")

    val sumEvenlyDivisible = randomNumbersTable.zipWithIndex.flatMap { case (row, i) =>
      row.zipWithIndex.map { case (item, index) =>
        for (i <- row.indices if item.toInt % row(i).toInt == 0 && index != i) yield {
          item.toInt / row(i).toInt
        }
      }.filter(item => item.nonEmpty).head
    }.sum

    println("DAY 2 - Corruption Checksum 2/2")
    println(s"Find the only two numbers in each row where one evenly divides the other and add up each row's result ${sumEvenlyDivisible}")
    println("")
  }
}
