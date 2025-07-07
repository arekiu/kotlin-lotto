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

    fun run() {
        val userAmount = inputView.takePurchaseInput()
        val tickets = ticketSeller.createRandomTickets(userAmount)
        resultView.printLottos(tickets)

        val winningNumbers = inputView.takeWinningNumbers()
        val bonusNumber = inputView.takeBonusNumber(winningNumbers)
        val prizeNumbers = PrizeNumbers(winningNumbers, bonusNumber)
        val dataLottoMachine = LottoMachine(tickets, prizeNumbers)
        handleResults(dataLottoMachine, userAmount)
    }

    fun handleResults(lottoMachine : LottoMachine, userAmount: Int) {
        val ticketsResult = lottoMachine.evaluateTicketsResult()
        val returnRate = lottoMachine.evaluateReturnRate(ticketsResult, userAmount)
        resultView.printResult(ticketsResult, returnRate)
    }
}
