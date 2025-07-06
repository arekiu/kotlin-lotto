package lotto.model

class LottoMachine(
    val lottoTickets: List<Lotto>,
    val prizeNumbers: PrizeNumbers,
    private val lottoManager: LottoManager = LottoManager()
) {

    fun evaluateTicketsResult() = lottoManager.manageTicketsEvaluation(lottoTickets, prizeNumbers)

    fun evaluateReturnRate(results: MutableMap<Rank, Int>, userAmount: Int): Double {
        val totalPrize = lottoManager.calculateTotalPrize(results)
        return lottoManager.calculateReturnRate(totalPrize, userAmount)
    }
}
