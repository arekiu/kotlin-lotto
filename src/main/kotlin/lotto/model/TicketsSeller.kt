package lotto.model

class TicketsSeller(
    private val numbersGenerator: NumbersGenerator = RandomNumbersGenerator(),
) {
    fun calculateTickets(userAmount: Int) = userAmount / LOTTO_PRICE

    fun createRandomTickets(numberOfTickets: Int): List<LottoTicket> {
        return List(numberOfTickets) { LottoTicket(numbersGenerator.generateNumbers()) }
    }

    fun createCustomTickets(numbersForLottos: List<List<Int>>) = numbersForLottos.map { LottoTicket(it) }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
