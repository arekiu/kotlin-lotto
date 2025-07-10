package lotto.view

import lotto.model.InputValidator

class InputView {
    val validator = InputValidator()

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

    fun takeNumberOfCustomTickets(totalNumberOfTickets: Int): Int {
        while (true) {
            try {
                println(ASK_NUMBER_OF_TICKETS)
                val input = readln()
                validator.validateNumberOfTickets(input, totalNumberOfTickets)
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun takeCustomLottoNumbers(numberOfManualTickets: Int): MutableList<List<Int>> {
        val numbersForCustomTickets = mutableListOf<List<Int>>()
        if (numberOfManualTickets == 0) {
            return numbersForCustomTickets
        }
        println(ASK_TICKET_NUMBERS)
        while (true) {
            try {
                val input = readln().split(",")
                input.forEach { item -> item.trim() }
                validator.validateTicketNumbers(input)
                val ticketNumbers = input.map { it.toInt() }
                numbersForCustomTickets.add(ticketNumbers)
                if (numbersForCustomTickets.size == numberOfManualTickets) {
                    return numbersForCustomTickets
                }
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun takeWinningNumbers(): List<Int> {
        while (true) {
            try {
                println()
                println(ASK_WINNING_NUMBERS)
                val input = readln().split(",")
                input.forEach { item -> item.trim() }
                validator.validateTicketNumbers(input)
                return input.map { it.toInt() }
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun takeBonusNumber(winningNumbers: List<Int>): Int {
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
        const val ASK_NUMBER_OF_TICKETS = "Enter the number of manual tickets to purchase."
        const val ASK_TICKET_NUMBERS = "Enter the numbers for manual tickets."
        const val ASK_WINNING_NUMBERS = "Please enter last week's winning numbers."
        const val ASK_BONUS_NUMBER = "Please enter the bonus number."
    }
}
