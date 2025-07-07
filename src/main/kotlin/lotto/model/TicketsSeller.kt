package lotto.model

class TicketsSeller(
    private val ticketGenerator: TicketGenerator = TicketGenerator(),
    private val numberGenerator: NumberGenerator = NumberGenerator()
) {

    fun calculateTickets(userAmount: Int) = userAmount / LOTTO_PRICE

    fun createRandomTickets(userAmount: Int): List<LottoTicket> {
        val amountOfTickets = calculateTickets(userAmount)
        val randomNumbers = numberGenerator.generateRandomNumbers()
        return List(amountOfTickets) { ticketGenerator.createLottoTicket(randomNumbers) }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
