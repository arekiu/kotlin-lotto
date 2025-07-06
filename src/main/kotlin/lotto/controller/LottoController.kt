package lotto.controller

import lotto.model.LottoMachine
import lotto.model.PrizeNumbers
import lotto.model.TicketsSeller
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val ticketSeller = TicketsSeller()

    private var userAmount = 0

    fun runMachine() {
        val dataLottoMachine = handleUserInput()
        handleResults(dataLottoMachine)
    }

    fun handleUserInput(): LottoMachine {
        userAmount = inputView.takePurchaseInput()
        val tickets = ticketSeller.createRandomTickets(userAmount)
        resultView.printLottos(tickets)

        val winningNumbers = inputView.takeWinningNumbers()
        val bonusNumber = inputView.takeBonusNumber(winningNumbers)
        val prizeNumbers = PrizeNumbers(winningNumbers, bonusNumber)
        return LottoMachine(tickets, prizeNumbers)
    }

    fun handleResults(lottoMachine : LottoMachine) {
        val ticketsResult = lottoMachine.evaluateTicketsResult()
        resultView.printResult(ticketsResult)

        val returnRate = lottoMachine.evaluateReturnRate(ticketsResult, userAmount)
        resultView.printReturnRate(returnRate)
    }
}
