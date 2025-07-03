package lotto

class ResultView() {
    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.count()} tickets.")
        lottos.forEach { lotto ->
            val lottoNumbers = lotto.getNumbers()
            println(lottoNumbers.joinToString(",", "[", "]"))
        }
    }

    fun printResult(results: MutableMap<Rank, Int>) {
        println()
        println(PRESENT_WINNING)
        println(SEPARATOR)
        println("3 Matches (5,000 KRW) - ${results.getValue(Rank.FIFTH)} tickets")
        println("4 Matches (50,000 KRW) - ${results.getValue(Rank.FOURTH)} tickets")
        println("5 Matches (1,500,000 KRW) - ${results.getValue(Rank.THIRD)} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) - ${results.getValue(Rank.SECOND)} tickets")
        println("6 Matches (2,000,000,000 KRW) - ${results.getValue(Rank.FIRST)} tickets")
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
