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
        tickets: List<LottoTicket>,
        prizeNumbers: PrizeNumbers
    ): MutableMap<Rank, Int> {
        val prizeCounter = createMap()
        tickets.forEach { ticket ->
            compareTicket(ticket, prizeNumbers)
            val chosenRank = Rank.getRank(ticket.numberOfHits, ticket.hasBonus)
            prizeCounter[chosenRank] = prizeCounter.getValue(chosenRank) + 1
        }
        return prizeCounter
    }

    fun compareTicket(lottoTicket: LottoTicket, prizeNumbers: PrizeNumbers) {
        lottoTicket.numberOfHits = compareTicketToWinningNumbers(lottoTicket, prizeNumbers.winningNumbers)
        if (lottoTicket.numberOfHits == 5) {
            lottoTicket.hasBonus = compareTicketToBonusNumber(lottoTicket, prizeNumbers.bonusNumber)
        }
    }

    private fun compareTicketToWinningNumbers(
        lottoTicket: LottoTicket,
        winningNumbers: List<LottoNumber>,
    ) = winningNumbers.count { it in lottoTicket.lottoNumbers }

    private fun compareTicketToBonusNumber(
        lottoTicket: LottoTicket,
        bonusNumber: LottoNumber,
    ) = bonusNumber in lottoTicket.lottoNumbers

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
