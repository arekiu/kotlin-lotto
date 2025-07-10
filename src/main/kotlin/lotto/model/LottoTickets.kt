package lotto.model

class LottoTickets(val tickets: List<LottoTicket>) {
    fun evaluateAll(prizeNumbers: PrizeNumbers): LottoResults {
        val prizeCounter = Rank.entries.associateWith { 0 }.toMutableMap()

        tickets.forEach { ticket ->
            ticket.compareTicket(prizeNumbers)
            val rank = Rank.getRank(ticket.numberOfHits, ticket.hasBonus)
            prizeCounter[rank] = prizeCounter.getValue(rank) + 1
        }
        return LottoResults(prizeCounter)
    }
}
