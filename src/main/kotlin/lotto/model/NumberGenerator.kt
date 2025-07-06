package lotto.model

import kotlin.collections.shuffled

class NumberGenerator {

    fun generateNumbers() = (MINIMUM_VALUE..MAXIMUM_VALUE).shuffled().take(6).sorted()

    companion object {
        const val MINIMUM_VALUE = 1
        const val MAXIMUM_VALUE = 45
    }
}
