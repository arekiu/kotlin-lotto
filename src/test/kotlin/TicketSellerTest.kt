package lotto

import lotto.model.TicketsSeller
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TicketSellerTest {
    val ticketSeller = TicketsSeller()

    @Test
    fun `should return right amount of tickets`() {
        val tickets = ticketSeller.createRandomTickets(5)
        assertEquals(tickets.count(), 5)
    }

    @Test
    fun `ticket should contain 6 numbers`() {
        val tickets = ticketSeller.createRandomTickets(5)
        val numbersInTicket = tickets[0].lottoNumbers
        assertEquals(numbersInTicket.count(), 6)
    }

    @Test
    fun `should return tight amount of custom tickets`() {
        val ticketNumbers = listOf(1, 2, 3, 4, 5, 6)
        val ticketNumbers2 = listOf(7, 8, 9, 10, 11, 12)
        val numbersForLottos = listOf(ticketNumbers, ticketNumbers2)
        val lottos = ticketSeller.createCustomTickets(numbersForLottos)
        assertEquals(lottos.count(), 2)
    }
}
