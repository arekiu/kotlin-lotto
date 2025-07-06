package lotto.model

class TicketsSeller(
    private val ticketGenerator: TicketGenerator = TicketGenerator(),
    private val numberGenerator: NumberGenerator = NumberGenerator()
) {

    fun calculateTickets(userAmount: Int) = userAmount / LOTTO_PRICE

    fun createRandomTickets(userAmount: Int): List<Lotto> {
        val amountOfTickets = calculateTickets(userAmount)
        return List(amountOfTickets) { ticketGenerator.createLottoTicket(numberGenerator.generateNumbers()) }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
