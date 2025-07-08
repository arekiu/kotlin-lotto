package lotto.model

class LottoEvaluator(
) {

    fun calculateTotalPrize(results: Map<Rank, Int>): Int {
        var totalPrize = 0
        results.map { (key, value) -> totalPrize += key.winningMoney * value }
        return totalPrize
    }

    fun calculateReturnRate(
        totalPrize: Int,
        userAmount: Int,
    ) = totalPrize.toDouble() / userAmount.toDouble()

    fun evaluateReturnRate(results: Map<Rank, Int>, userAmount: Int): Double {
        val totalPrize = calculateTotalPrize(results)
        return calculateReturnRate(totalPrize, userAmount)
    }
}
