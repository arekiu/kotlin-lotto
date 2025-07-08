package lotto

import lotto.controller.LottoController
import lotto.model.TicketGenerator
import lotto.model.TicketsSeller
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val ticketSeller = TicketsSeller()
    val ticketGenerator = TicketGenerator()

    val lottoController = LottoController(
        inputView,
        resultView,
        ticketSeller,
        ticketGenerator
    )

    lottoController.run()
}
