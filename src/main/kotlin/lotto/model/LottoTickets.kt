package lotto.model

class LottoTickets(val tickets: List<LottoTicket>) {

    private fun createMap(): MutableMap<Rank, Int> {
        val prizeCounter = mutableMapOf<Rank, Int>()
        for (rank in Rank.entries) {
            prizeCounter[rank] = 0
        }
        return prizeCounter
    }

    fun evaluateAll(prizeNumbers: PrizeNumbers): Map<Rank, Int> {
        val prizeCounter = createMap()

        tickets.forEach { ticket ->
            ticket.compareTicket(prizeNumbers)
            val rank = Rank.getRank(ticket.numberOfHits, ticket.hasBonus)
            prizeCounter[rank] = prizeCounter.getValue(rank) + 1
        }
        return prizeCounter
    }
}
