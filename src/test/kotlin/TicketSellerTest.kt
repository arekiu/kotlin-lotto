package lotto

import lotto.model.TicketsSeller
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TicketSellerTest {
    @Test
    fun `should return right amount of tickets`() {
        val ticketSeller = TicketsSeller()
        val tickets = ticketSeller.createRandomTickets(5000)
        assertEquals(tickets.count(), 5)
    }

    @Test
    fun `ticket should contain 6 numbers`() {
        val ticketSeller = TicketsSeller()
        val tickets = ticketSeller.createRandomTickets(1000)
        val numbersInTicket = tickets[0].lottoNumbers
        assertEquals(numbersInTicket.count(), 6)
    }
}
