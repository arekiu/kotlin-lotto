package lotto

import lotto.model.LottoEvaluator
import lotto.model.LottoNumber
import lotto.model.LottoTickets
import lotto.model.PrizeNumbers
import lotto.model.TicketGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoManagerTest {

    val ticketGenerator = TicketGenerator()

    @Test
    fun `correct return rate is calculated`() {
        val amount = 3000
        val lottoTicket = LottoTickets(listOf(ticketGenerator.createLottoTicket(listOf(1, 2, 3, 4, 5, 6))))
        val winningNumbers = ticketGenerator.createLottoTicket(listOf(1, 2, 3, 10, 11, 13))
        val bonusNumber = LottoNumber.from(6)
        val prizeNumbers = PrizeNumbers(winningNumbers, bonusNumber)
        val results = lottoTicket.evaluateAll( prizeNumbers)
        val lottoEvaluator = LottoEvaluator(results, amount)
        assertEquals(lottoEvaluator.evaluateReturnRate(), 1.6666666666666667)
    }
}
