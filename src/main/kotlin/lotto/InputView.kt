package lotto

class InputView {
    val validator = Validator()

    fun takePurchaseInput(): Int {
        while (true) {
            try {
                println(ASK_AMOUNT)
                val input = readln()
                validator.validateAmount(input)
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun takeWinningNumbers(): List<String> {
        while (true) {
            try {
                println()
                println(ASK_WINNING_NUMBERS)
                val input = readln().split(",")
                input.forEach { item -> item.trim() }
                validator.validateWinningNumbers(input)
                return input
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun takeBonusNumber(winningNumbers: List<String>): Int {
        while (true) {
            try {
                println(ASK_BONUS_NUMBER)
                val bonusInput = readln()
                validator.validateBonusNumber(bonusInput, winningNumbers)
                return bonusInput.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    companion object {
        const val ASK_AMOUNT = "Please enter the purchase amount."
        const val ASK_WINNING_NUMBERS = "Please enter last week's winning numbers."
        const val ASK_BONUS_NUMBER = "Please enter the bonus number."
    }
}
