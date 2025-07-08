package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val ticketSeller: TicketsSeller,
    private val ticketGenerator: TicketGenerator
) {

    fun run() {
        val userAmount = inputView.takePurchaseInput()

        val allTickets = buyTickets(userAmount)

        resultView.printLottos(allTickets)

        val prizeNumbers = createPrizeNumbers()
        val dataLottoMachine = LottoMachine(allTickets, prizeNumbers)
        handleResults(dataLottoMachine, userAmount)
    }

    private fun buyTickets(userAmount: Int): List<LottoTicket> {
        var numberOfTickets = ticketSeller.calculateTickets(userAmount)
        val numberOfManualTickets = inputView.takeNumberOfCustomTickets(numberOfTickets)
        val customTicketNumbers = inputView.takeCustomLottoNumbers(numberOfManualTickets)
        val customTickets = ticketSeller.createCustomTickets(customTicketNumbers)
        numberOfTickets -= numberOfManualTickets

        val randomTickets = ticketSeller.createRandomTickets(numberOfTickets)
        return customTickets + randomTickets
    }

    private fun createPrizeNumbers(): PrizeNumbers {
        val winningNumbers = inputView.takeWinningNumbers()
        val bonusNumber = inputView.takeBonusNumber(winningNumbers)
        val winningLottoNumbers = ticketGenerator.generateLottoNumbers(winningNumbers)
        val bonusLottoNumber = LottoNumber.from(bonusNumber)
        return PrizeNumbers(winningLottoNumbers, bonusLottoNumber)
    }

    private fun handleResults(lottoMachine: LottoMachine, userAmount: Int) {
        val ticketsResult = lottoMachine.evaluateTicketsResult()
        val returnRate = lottoMachine.evaluateReturnRate(ticketsResult, userAmount)
        resultView.printResult(ticketsResult, returnRate)
    }
}
