package lotto.model

class InputValidator {
    fun validateAmount(userAmount: String) {
        require(userAmount.toIntOrNull() != null) { "Input is not a number" }
        require((userAmount.toInt() % LOTTO_PRICE) == 0) { "Input is not multiple of 1000" }
    }

    fun validateNumberOfTickets(
        input: String,
        totalNumberOfTickets: Int,
    ) {
        require(input.toIntOrNull() != null) { "Input is not a number" }
        require(input.toInt() <= totalNumberOfTickets) { "Input is bigger than number of tickets" }
        require(input.toInt() >= 0) { "Input must be positive number" }
    }

    fun validateTicketNumbers(userInput: List<String>) {
        require(userInput.all { it.toIntOrNull() != null }) { "Input has invalid numbers" }
        require(userInput.count() == 6) { "Input should have 6 numbers" }
        require(userInput.count() == userInput.toSet().count()) { "Numbers should be unique" }
        require(userInput.all { it.toInt() in 1..45 }) { "Numbers should be between 1 and 45" }
    }

    fun validateBonusNumber(
        bonusInput: String,
        winningNumbers: List<Int>,
    ) {
        require(bonusInput.toIntOrNull() != null) { "Bonus number should be entered" }
        require(bonusInput.toInt() !in winningNumbers) { "Bonus number should be different than winning numbers" }
        require(bonusInput.toInt() in 1..45) { "Bonus number should be between 1 and 45" }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
