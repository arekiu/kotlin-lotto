package lotto.model

class TicketsSeller(
    private val ticketGenerator: TicketGenerator = TicketGenerator(),
    private val numberGenerator: NumberGenerator = NumberGenerator()
) {

    fun calculateTickets(userAmount: Int) = userAmount / LOTTO_PRICE

    fun createRandomTickets(numberOfTickets: Int): List<LottoTicket> {
        val randomNumbers = numberGenerator.generateRandomNumbers()
        return List(numberOfTickets) { ticketGenerator.createLottoTicket(randomNumbers) }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
