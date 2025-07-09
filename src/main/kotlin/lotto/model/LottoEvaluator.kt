package lotto.model

class LottoEvaluator(
    val results: Map<Rank, Int>, val userAmount: Int
) {

    private fun calculateTotalPrize(): Int {
        var totalPrize = 0
        results.map { (key, value) -> totalPrize += key.winningMoney * value }
        return totalPrize
    }

    private fun calculateReturnRate(
        totalPrize: Int,
        userAmount: Int,
    ) = totalPrize.toDouble() / userAmount.toDouble()

    fun evaluateReturnRate(): Double {
        val totalPrize = calculateTotalPrize()
        return calculateReturnRate(totalPrize, userAmount)
    }
}
