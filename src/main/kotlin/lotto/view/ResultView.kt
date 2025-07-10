package lotto.view

import lotto.model.LottoResults
import lotto.model.LottoTickets
import lotto.model.Rank

class ResultView() {
    fun printLottos(lottos: LottoTickets) {
        println("You have purchased ${lottos.tickets.count()} tickets.")
        lottos.tickets.forEach { lotto ->
            println(lotto.lottoNumbers.joinToString(",", "[", "]"))
        }
    }

    fun printResult(
        results: LottoResults,
        returnRate: Double,
    ) {
        println()
        printResultTickets(results)
        printReturnRate(returnRate)
    }

    fun printResultTickets(results: LottoResults) {
        println(
            """
            $PRESENT_WINNING
            $SEPARATOR
            3 Matches (${"%,d".format(Rank.FIFTH.winningMoney)} KRW) - ${results.obtainWinsForRank(Rank.FIFTH)} tickets
            4 Matches (${"%,d".format(Rank.FOURTH.winningMoney)} KRW) - ${results.obtainWinsForRank(Rank.FOURTH)} tickets
            5 Matches (${"%,d".format(Rank.THIRD.winningMoney)} KRW) - ${results.obtainWinsForRank(Rank.THIRD)} tickets
            5 Matches + Bonus Ball (${"%,d".format(Rank.SECOND.winningMoney)} KRW) - ${results.obtainWinsForRank(Rank.SECOND)} tickets
            6 Matches (${"%,d".format(Rank.FIRST.winningMoney)} KRW) - ${results.obtainWinsForRank(Rank.FIRST)} tickets
            """.trimIndent(),
        )
    }

    fun printReturnRate(returnRate: Double) {
        val formattedRate = String.format("%.1f", returnRate).replace(',', '.')
        println("Total return rate is $formattedRate")
    }

    companion object Messages {
        const val PRESENT_WINNING = "Winning Statistics"
        const val SEPARATOR = "------------------"
    }
}
