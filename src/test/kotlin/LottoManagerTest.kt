package lotto

import lotto.model.LottoManager
import lotto.model.PrizeNumbers
import lotto.model.TicketGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoManagerTest {
    val lottoManager = LottoManager()
    val ticketGenerator = TicketGenerator()

    @Test
    fun `correct return rate is calculated`() {
        val results = 5000
        val amount = 3000
        assertEquals(lottoManager.calculateReturnRate(results, amount), 1.6666666666666667)
    }

    @Test
    fun `calculates right prize number`() {
        val lottoTicket = ticketGenerator.createLottoTicket(listOf(1,2,3,4,5,6))
        val winningNumbers = listOf(1,2,3,4,5,7)
        val bonusNumber = 6
        val prizeNumbers = PrizeNumbers(winningNumbers, bonusNumber)
        val results = lottoManager.manageTicketsEvaluation(listOf(lottoTicket),prizeNumbers )
        assertEquals(lottoManager.calculateTotalPrize(results), 30000000)
    }
}
