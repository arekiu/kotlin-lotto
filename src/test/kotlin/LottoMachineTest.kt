package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoMachineTest {
    @Test
    fun `should return right amount of tickets`() {
        val lottoMachine = LottoMachine()
        assertEquals(lottoMachine.createTickets(5000).count(), 5)
    }

    @Test
    fun `ticket should contain 6 numbers`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.createTickets(1000)
        val numbersInTicket = tickets[0].getNumbers()
        assertEquals(numbersInTicket.count(), 6)
    }

    @Test
    fun `amount of tickets were generated`() {
        val lottoMachine = LottoMachine()
        assertEquals(lottoMachine.createTickets(4000).count(), 4)
    }

    @Test
        fun `correct amount of rate is calculated`() {
            val lottoMachine = LottoMachine()
            val results = 5000
            val amount = 3000
            assertEquals(lottoMachine.calculateReturnRate(results, amount), 1.6666666666666667)
        }
}
