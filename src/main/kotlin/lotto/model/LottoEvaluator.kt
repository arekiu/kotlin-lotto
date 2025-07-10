package lotto.model

class LottoEvaluator(
    val results: LottoResults,
    val userAmount: Int,
) {
    private fun calculateReturnRate(
        totalPrize: Int,
        userAmount: Int,
    ) = totalPrize.toDouble() / userAmount.toDouble()

    fun evaluateReturnRate() = calculateReturnRate(results.calculateTotalPrize(), userAmount)
}
