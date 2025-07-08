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

        val allTickets = LottoTickets(buyTickets(userAmount))

        resultView.printLottos(allTickets)

        val prizeNumbers = createPrizeNumbers()

        handleResults(allTickets, prizeNumbers, userAmount)
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
        val winningLottoNumbersTicket = ticketGenerator.createLottoTicket(winningNumbers)
        val bonusLottoNumber = LottoNumber.from(bonusNumber)
        return PrizeNumbers(winningLottoNumbersTicket, bonusLottoNumber)
    }

    private fun handleResults(allTickets: LottoTickets, prizeNumbers: PrizeNumbers, userAmount: Int) {
        val lottoEvaluator = LottoEvaluator()
        val ticketsResult = allTickets.evaluateAll(prizeNumbers)
        val returnRate = lottoEvaluator.evaluateReturnRate(ticketsResult, userAmount)
        resultView.printResult(ticketsResult, returnRate)
    }
}
