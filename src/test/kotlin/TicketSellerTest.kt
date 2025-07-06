package lotto

import lotto.model.TicketsSeller
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class TicketSellerTest {
    @Test
    fun `should return right amount of tickets`() {
        val ticketSeller = TicketsSeller(5000)
        val tickets = ticketSeller.createRandomTickets()
        assertEquals(tickets.count(), 5)
    }

    @Test
    fun `ticket should contain 6 numbers`() {
        val ticketSeller = TicketsSeller(1000)
        val tickets = ticketSeller.createRandomTickets()
        val numbersInTicket = tickets[0].lottoNumbers
        assertEquals(numbersInTicket.count(), 6)
    }
}
