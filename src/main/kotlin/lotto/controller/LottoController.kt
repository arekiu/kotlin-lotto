package lotto.controller

import lotto.model.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val lottoMachine = LottoMachine()
    private var userAmount = 0

    fun runMachine() {
        handleUserInput()
        handleResults()
    }

    fun handleUserInput() {
        userAmount = inputView.takePurchaseInput()
        lottoMachine.createTickets(userAmount)
        resultView.printLottos(lottoMachine.getTickets())

        lottoMachine.setWinningNumbers(inputView.takeWinningNumbers())
        lottoMachine.setBonusNumber(inputView.takeBonusNumber(lottoMachine.getWinningNumbers()))
    }

    fun handleResults() {
        val ticketsResult = lottoMachine.evaluateTicketsResult()
        resultView.printResult(ticketsResult)

        val returnRate = lottoMachine.evaluateReturnRate(ticketsResult, userAmount)
        resultView.printReturnRate(returnRate)
    }
}
