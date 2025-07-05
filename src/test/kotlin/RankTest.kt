package lotto

import lotto.model.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `should assign the corresponding rank when has bonus`() {
        val matchingNumber = 5
        val hasBonus = true
        assertEquals(Rank.getRank(matchingNumber, hasBonus).toString(),"SECOND")
    }

    @Test
    fun `should assign the corresponding rank when doesnt have bonus`() {
        val matchingNumber = 5
        val hasBonus = false

        assertEquals(Rank.getRank(matchingNumber, hasBonus).toString(),"THIRD")
    }

    @Test
    fun `should assign MISS when is not matching less than 3 numbers`() {
        val matchingNumber = 2
        val hasBonus = false

        assertEquals(Rank.getRank(matchingNumber, hasBonus).toString(), "MISS")
    }
}
