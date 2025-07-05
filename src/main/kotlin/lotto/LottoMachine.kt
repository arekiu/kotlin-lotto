package lotto

class LottoMachine() {

    private fun calculateTickets(userAmount: Int) = userAmount / LOTTO_PRICE

    private fun generateNumbers() = (MIN_VAL..MAX_VAL).shuffled().take(6).sorted()

    fun createTickets(userAmount: Int): List<Lotto> {
        val amountOfTickets = calculateTickets(userAmount)
        return List(amountOfTickets) { Lotto(generateNumbers()) }
    }

    private fun compareTicketToWinningNumbers(
        ticket: Lotto,
        winningNumbers: List<Int>,
    ): Int {
        return winningNumbers.count { it in ticket.getNumbers() }
    }

    private fun compareTicketToBonusNumber(
        lotto: Lotto,
        bonusNumber: Int,
    ): Boolean {
        return bonusNumber in lotto.getNumbers()
    }

    private fun createMap(): MutableMap<Rank, Int> {
        val prizeCounter = mutableMapOf<Rank, Int>()
        for (rank in Rank.values()) {
            prizeCounter[rank] = 0
        }
        return prizeCounter
    }

    fun compareTickets(
        lottos: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ): MutableMap<Rank, Int> {
        val prizeCounter = createMap()

        lottos.forEach { ticket ->
            var hasBonus = false
            val matches = compareTicketToWinningNumbers(ticket, winningNumbers)
            if (matches == 5) {
                hasBonus = compareTicketToBonusNumber(ticket, bonusNumber)
            }
            val chosen = Rank.valueOf(matches, hasBonus)
            prizeCounter[chosen] = prizeCounter.getValue(chosen) + 1
        }
        return prizeCounter
    }

    private fun calculateTotalPrize(results: MutableMap<Rank, Int>): Int {
       var totalPrize = 0
        results.forEach { (key, value) ->
            totalPrize += key.winningMoney * value
        }
        return totalPrize
    }

    fun calculateReturnRate(
        results: MutableMap<Rank, Int>,
        userAmount: Int,
    ): Double {
        val totalPrize = calculateTotalPrize(results)
        return (totalPrize.toDouble() / userAmount.toDouble())
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val MIN_VAL = 1
        const val MAX_VAL = 45
    }
}
