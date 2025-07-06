package lotto.model

class LottoManager {

    private fun createMap(): MutableMap<Rank, Int> {
        val prizeCounter = mutableMapOf<Rank, Int>()
        for (rank in Rank.entries) {
            prizeCounter[rank] = 0
        }
        return prizeCounter
    }

    fun manageTicketsEvaluation(
        tickets: List<Lotto>,
        prizeNumbers: PrizeNumbers
    ): MutableMap<Rank, Int> {
        val prizeCounter = createMap()
        tickets.forEach { ticket ->
            ticket.compareTicket(prizeNumbers.winningNumbers, prizeNumbers.bonusNumber)
            val chosenRank = Rank.getRank(ticket.numberOfHits, ticket.hasBonus)
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

}
