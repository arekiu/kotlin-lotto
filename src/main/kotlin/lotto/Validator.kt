package lotto

class Validator {
    fun validateAmount(userAmount: String) {
        if (userAmount.toIntOrNull() == null) {
            throw IllegalArgumentException("Input is not a number")
        }
        if ((userAmount.toInt() % LOTTO_PRICE) != 0) {
            throw IllegalArgumentException("Input is not multiple of 1000")
        }
    }

    fun validateWinningNumbers(userInput: List<String>) {
        userInput.forEach { item ->
            if (item.toIntOrNull() == null) {
                throw IllegalArgumentException("Input has invalid numbers")
            }
        }
        if (userInput.count() != 6) {
            throw IllegalArgumentException("Input should have 6 numbers")
        }
        if (userInput.count() != userInput.toSet().count()) {
            throw IllegalArgumentException("Numbers should be unique")
        }
        userInput.forEach { item ->
            if (item.toInt() !in 1..45) {
                throw IllegalArgumentException("The winning numbers should be between 1 and 45")
            }
        }
    }

    fun validateBonusNumber(
        bonusInput: String,
        winningNumbers: List<Int>,
    ) {
        if (bonusInput.toIntOrNull() == null) {
            throw IllegalArgumentException("Bonus number should be entered")
        }

        if (bonusInput.toInt() in winningNumbers) {
            throw IllegalArgumentException("Bonus number should be different than winning numbers")
        }
        if (bonusInput.toInt() !in 1..45) {
            throw IllegalArgumentException("The bonus number should be between 1 and 45")
        }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
