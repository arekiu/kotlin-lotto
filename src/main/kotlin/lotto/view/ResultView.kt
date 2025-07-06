package lotto.view

import lotto.model.Lotto
import lotto.model.Rank

class ResultView() {
    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.count()} tickets.")
        lottos.forEach { lotto ->
            val lottoNumbers = lotto.lottoNumbers
            println(lottoNumbers.joinToString(",", "[", "]"))
        }
    }

    fun printResult(results: MutableMap<Rank, Int>) {
        println()
        println(PRESENT_WINNING)
        println(SEPARATOR)
        println(
            """
        3 Matches (${ "%,d".format(Rank.FIFTH.winningMoney) } KRW) - ${results.getValue(Rank.FIFTH)} tickets
        4 Matches (${ "%,d".format(Rank.FOURTH.winningMoney) } KRW) - ${results.getValue(Rank.FOURTH)} tickets
        5 Matches (${ "%,d".format(Rank.THIRD.winningMoney) } KRW) - ${results.getValue(Rank.THIRD)} tickets
        5 Matches + Bonus Ball (${ "%,d".format(Rank.SECOND.winningMoney) } KRW) - ${results.getValue(Rank.SECOND)} tickets
        6 Matches (${ "%,d".format(Rank.FIRST.winningMoney) } KRW) - ${results.getValue(Rank.FIRST)} tickets
        """.trimIndent()
        )
    }

    fun printReturnRate(rate: Double) {
        val formattedRate = String.format("%.1f", rate).replace(',', '.')
        println("Total return rate is $formattedRate")
    }

    companion object Messages {
        const val PRESENT_WINNING = "Winning Statistics"
        const val SEPARATOR = "------------------"
    }
}
