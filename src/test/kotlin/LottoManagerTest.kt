package lotto

import lotto.model.LottoManager
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoManagerTest {

    val lottoManager = LottoManager()

    @Test
    fun `correct return rate is calculated`() {
        val results = 5000
        val amount = 3000
        assertEquals(lottoManager.calculateReturnRate(results, amount), 1.6666666666666667)
    }

    @Test
    fun `calculates right prize number`() {
        val lottoTicket = lottoManager.createLottoTicket(listOf(1,2,3,4,5,6))
        val winningNumbers = listOf(1,2,3,4,5,7)
        val bonusNumber = 6
        val results = lottoManager.manageTicketsEvaluation(listOf(lottoTicket), winningNumbers, bonusNumber)
        assertEquals(lottoManager.calculateTotalPrize(results), 30000000)
    }
}
