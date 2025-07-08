package lotto

import lotto.model.LottoEvaluator
import lotto.model.LottoNumber
import lotto.model.LottoTickets
import lotto.model.PrizeNumbers
import lotto.model.TicketGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoManagerTest {
    val lottoEvaluator = LottoEvaluator()
    val ticketGenerator = TicketGenerator()

    @Test
    fun `correct return rate is calculated`() {
        val results = 5000
        val amount = 3000
        assertEquals(lottoEvaluator.calculateReturnRate(results, amount), 1.6666666666666667)
    }

    @Test
    fun `calculates right prize number`() {
        val lottoTicket = LottoTickets(listOf(ticketGenerator.createLottoTicket(listOf(1, 2, 3, 4, 5, 6))))
        val winningNumbers = ticketGenerator.createLottoTicket(listOf(1, 2, 3, 4, 5, 7))
        val bonusNumber = LottoNumber.from(6)
        val prizeNumbers = PrizeNumbers(winningNumbers, bonusNumber)
        val results = lottoTicket.evaluateAll( prizeNumbers)
        assertEquals(lottoEvaluator.calculateTotalPrize(results), 30000000)
    }
}
