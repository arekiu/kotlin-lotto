package lotto.model

class LottoMachine(
    private val lottoTickets: List<Lotto>,
    private val prizeNumbers: PrizeNumbers,
    private val lottoManager: LottoManager = LottoManager()
) {

    fun evaluateTicketsResult() = lottoManager.manageTicketsEvaluation(lottoTickets, prizeNumbers)

    fun evaluateReturnRate(results: MutableMap<Rank, Int>, userAmount: Int): Double {
        val totalPrize = lottoManager.calculateTotalPrize(results)
        return lottoManager.calculateReturnRate(totalPrize, userAmount)
    }
}
