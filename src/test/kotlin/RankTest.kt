package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `sample test`() {
        val matchingNumber = 5
        val hasBonus = true
        assertThat(Rank.getRank(matchingNumber, hasBonus).toString()).isEqualTo("SECOND")
    }

    @Test
    fun `should assign the corresponding rank`() {
        val matchingNumber = 5
        val hasBonus = false

        assertThat(Rank.getRank(matchingNumber, hasBonus).toString()).isEqualTo("THIRD")
    }

    @Test
    fun `should assign MISS when is not matching less than 3 numbers`() {
        val matchingNumber = 2
        val hasBonus = false

        assertThat(Rank.getRank(matchingNumber, hasBonus).toString()).isEqualTo("MISS")
    }
}
