package lotto

import lotto.model.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `throw error exception when amount of numbers aren't 6`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }

    @Test
    fun `throw error exception when numbers are out of the range between 1 and 45`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 46)
        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }

    @Test
    fun `throw error exception when numbers are duplicated`() {
        val lottoNumbers = listOf(1, 2, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }
}
