package lotto

import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals

class LottoMachineTest {
    @Test
    fun `should return right amount of tickets`() {
        val lottoMachine = LottoMachine()
        assertEquals("Amount isn't a multiple of 1000", lottoMachine.createTickets(5000).count(), 5)
    }

    @Test
    fun `ticket should contain 6 numbers`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.createTickets(1000)
        val numbersInTicket = tickets[0].getNumbers()
        assertEquals("Ticket numbers aren't 6", numbersInTicket.count(), 6)
    }

    @Test
    fun `amount of tickets were generated`() {
        val lottoMachine = LottoMachine()
        assertEquals("Amount of tickets is different then expected", lottoMachine.createTickets(4000).count(), 4)
    }

    @Test
    fun `correct amount of rate is calculated`() {
        val lottoMachine = LottoMachine()
        val results = mutableMapOf<Rank, Int>()
        results[Rank.FIFTH] = 1
        val amount = 3000
        assertEquals("Rate result is different then expected", lottoMachine.calculateReturnRate(results, amount), 1.6666666666666667)
    }
}
