package lotto.model

class TicketsSeller(
    private val ticketGenerator: TicketGenerator = TicketGenerator(),
    private val numberGenerator: NumberGenerator = NumberGenerator()
) {

    fun calculateTickets(userAmount: Int) = userAmount / LOTTO_PRICE

    fun createRandomTickets(numberOfTickets: Int): List<LottoTicket> {
        return List(numberOfTickets) { ticketGenerator.createLottoTicket(numberGenerator.generateRandomNumbers()) }
    }

    fun createCustomTickets(numbersForLottos: List<List<Int>>) =
        numbersForLottos.map { ticketGenerator.createLottoTicket(it) }


    companion object {
        const val LOTTO_PRICE = 1000
    }
}
