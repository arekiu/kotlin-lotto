package lotto

import lotto.controller.LottoController
import lotto.model.TicketsSeller
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val ticketSeller = TicketsSeller()

    val lottoController =
        LottoController(
            inputView,
            resultView,
            ticketSeller,
        )

    lottoController.run()
}
