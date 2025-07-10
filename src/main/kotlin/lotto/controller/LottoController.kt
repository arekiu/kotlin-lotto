package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val ticketsSeller: TicketsSeller,
) {
    fun run() {
        val userAmount = inputView.takePurchaseInput()

        val allTickets = LottoTickets(buyTickets(userAmount))

        resultView.printLottos(allTickets)

        val prizeNumbers = createPrizeNumbers()

        val ticketsResult = allTickets.evaluateAll(prizeNumbers)

        val lottoEvaluator = LottoEvaluator(ticketsResult, userAmount)
        val returnRate = lottoEvaluator.evaluateReturnRate()

        resultView.printResult(ticketsResult, returnRate)
    }

    private fun buyTickets(userAmount: Int): List<LottoTicket> {
        val numberTotalOfTickets = ticketsSeller.calculateTickets(userAmount)
        val numberOfManualTickets = inputView.takeNumberOfCustomTickets(numberTotalOfTickets)
        val customTicketNumbers = inputView.takeCustomLottoNumbers(numberOfManualTickets)
        val customTickets = ticketsSeller.createCustomTickets(customTicketNumbers)
        val numberOfRandomTickets = numberTotalOfTickets - numberOfManualTickets

        val randomTickets = ticketsSeller.createRandomTickets(numberOfRandomTickets)
        return customTickets + randomTickets
    }

    private fun createPrizeNumbers(): PrizeNumbers {
        val winningNumbers = inputView.takeWinningNumbers()
        val bonusNumber = inputView.takeBonusNumber(winningNumbers)
        val winningLottoNumbersTicket = LottoTicket(winningNumbers)
        val bonusLottoNumber = LottoNumber.from(bonusNumber)
        return PrizeNumbers(winningLottoNumbersTicket, bonusLottoNumber)
    }
}
