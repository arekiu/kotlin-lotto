package lotto.model

class LottoManager {

    fun calculateTickets(userAmount: Int) = userAmount / LOTTO_PRICE

    fun generateNumbers() = (MINIMUM_VALUE..MAXIMUM_VALUE).shuffled().take(6).sorted()

    fun createLottoTicket(lottoNumbers: List<Int>) = Lotto(lottoNumbers)

    private fun createMap(): MutableMap<Rank, Int> {
        val prizeCounter = mutableMapOf<Rank, Int>()
        for (rank in Rank.entries) {
            prizeCounter[rank] = 0
        }
        return prizeCounter
    }

    fun manageTicketsEvaluation(
        tickets: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ): MutableMap<Rank, Int> {
        val prizeCounter = createMap()
        tickets.forEach { ticket ->
            ticket.compareTicket(winningNumbers, bonusNumber)
            val chosenRank = Rank.getRank(ticket.getNumberOfHits(), ticket.getBonusStatus())
            prizeCounter[chosenRank] = prizeCounter.getValue(chosenRank) + 1
        }
        return prizeCounter
    }

    fun calculateTotalPrize(results: MutableMap<Rank, Int>): Int {
        var totalPrize = 0
        results.map { (key, value) -> totalPrize += key.winningMoney * value }
        return totalPrize
    }

    fun calculateReturnRate(
        totalPrize: Int,
        userAmount: Int,
    ) = totalPrize.toDouble() / userAmount.toDouble()

    companion object {
        const val LOTTO_PRICE = 1000
        const val MINIMUM_VALUE = 1
        const val MAXIMUM_VALUE = 45
    }
}
