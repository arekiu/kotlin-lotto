package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val ticketSeller = TicketsSeller()
    private val ticketGenerator = TicketGenerator()

    fun run() {
        val userAmount = inputView.takePurchaseInput()
        val tickets = ticketSeller.createRandomTickets(userAmount)
        resultView.printLottos(tickets)

        val prizeNumbers = createPrizeNumbers()
        val dataLottoMachine = LottoMachine(tickets, prizeNumbers)
        handleResults(dataLottoMachine, userAmount)
    }

    fun createPrizeNumbers(): PrizeNumbers {
        val winningNumbers = inputView.takeWinningNumbers()
        val bonusNumber = inputView.takeBonusNumber(winningNumbers)
        val winningLottoNumbers = ticketGenerator.generateLottoNumbers(winningNumbers)
        val bonusLottoNumber = LottoNumber.from(bonusNumber)
        return PrizeNumbers(winningLottoNumbers, bonusLottoNumber)
    }

    fun handleResults(lottoMachine: LottoMachine, userAmount: Int) {
        val ticketsResult = lottoMachine.evaluateTicketsResult()
        val returnRate = lottoMachine.evaluateReturnRate(ticketsResult, userAmount)
        resultView.printResult(ticketsResult, returnRate)
    }
}
