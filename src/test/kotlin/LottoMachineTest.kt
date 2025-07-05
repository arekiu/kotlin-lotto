package lotto

import lotto.model.LottoMachine
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoMachineTest {
    @Test
    fun `should return right amount of tickets`() {
        val lottoMachine = LottoMachine()
        lottoMachine.createTickets(5000)
        assertEquals(lottoMachine.getTickets().count(), 5)
    }

    @Test
    fun `ticket should contain 6 numbers`() {
        val lottoMachine = LottoMachine()
        lottoMachine.createTickets(1000)
        val tickets = lottoMachine.getTickets()
        val numbersInTicket = tickets[0].getNumbers()
        assertEquals(numbersInTicket.count(), 6)
    }

    @Test
    fun `amount of tickets were generated`() {
        val lottoMachine = LottoMachine()
        lottoMachine.createTickets(4000)
        assertEquals(lottoMachine.getTickets().count(), 4)
    }
}
