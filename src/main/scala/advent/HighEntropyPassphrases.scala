package advent

import data.AdventData.passphrases

object HighEntropyPassphrases {

  def run(): Unit = {

    val passphrasesList = passphrases.split ("\n").toList

    val validPassphrases = passphrasesList.filter { phrase => phrase.split(" ").distinct.length == phrase.split(" ").length }
    println("DAY 4 - High Entropy Passphrases 1/2")
    println(s"There are ${validPassphrases.length} valid passphrases")
    println("")


    val validPassphrasesAnagrams = passphrasesList.filter { phrase =>
      val sortedPassphrase = phrase.split(" ").map(_.toCharArray.sorted.mkString(""))
      sortedPassphrase.distinct.length == sortedPassphrase.length
    }
    println("DAY 4 - High Entropy Passphrases 2/2")
    println(s"There are ${validPassphrasesAnagrams.length} Anagram valid passphrases")
    println("")
  }
}
