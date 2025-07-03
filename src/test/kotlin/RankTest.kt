package lotto

import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals

class RankTest {
    @Test
    fun `should assign the corresponding rank when it has bonus`() {
        val matchingNumber = 5
        val hasBonus = true

        assertEquals("Should match the right rank", Rank.valueOf(matchingNumber, hasBonus).toString(), "SECOND")
    }

    @Test
    fun `should assign the corresponding rank`() {
        val matchingNumber = 5
        val hasBonus = false

        assertEquals("Should match the right rank", Rank.valueOf(matchingNumber, hasBonus).toString(), "THIRD")
    }

    @Test
    fun `should assign MISS when is not matching less than 3 numbers`() {
        val matchingNumber = 2
        val hasBonus = false

        assertEquals("Should match the right rank", Rank.valueOf(matchingNumber, hasBonus).toString(), "MISS")
    }
}
