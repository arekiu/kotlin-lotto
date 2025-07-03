package lotto

fun main() {
    val inputView = InputView()
    val lottoMachine = LottoMachine()
    val resultView = ResultView()

    // Create a ticket from given amount
    val userAmount = inputView.takePurchaseInput()
    val tickets = lottoMachine.createTickets(userAmount)
    resultView.printLottos(tickets)

    // Compare winning tickets from given winning numbers
    val winningNumbers = inputView.takeWinningNumbers()
    val bonusNumber = inputView.takeBonusNumber(winningNumbers)
    val results = lottoMachine.compareTickets(tickets, winningNumbers, bonusNumber)
    resultView.printResult(results)

    // Calculate profit rate
    val rate = lottoMachine.calculateReturnRate(results, userAmount)
    resultView.printReturnRate(rate)
}
