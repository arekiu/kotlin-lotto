package lotto.model

class LottoMachine() {

    private val lottoManager = LottoManager()
    private lateinit var lottoTickets: List<Lotto>
    private var winningNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = 0

    fun createTickets(userAmount: Int) {
        val amountOfTickets = lottoManager.calculateTickets(userAmount)
        lottoTickets = List(amountOfTickets) { lottoManager.createLottoTicket(lottoManager.generateNumbers()) }
    }

    fun setWinningNumbers(numbers: List<Int>) {
        winningNumbers = numbers
    }

    fun setBonusNumber(number: Int) {
        bonusNumber = number
    }

    fun getTickets() = lottoTickets

    fun getWinningNumbers() = winningNumbers

    fun evaluateTicketsResult() = lottoManager.manageTicketsEvaluation(lottoTickets, winningNumbers, bonusNumber)

    fun evaluateReturnRate(results: MutableMap<Rank, Int>, userAmount: Int): Double {
        val totalPrize = lottoManager.calculateTotalPrize(results)
        return lottoManager.calculateReturnRate(totalPrize, userAmount)
    }
}
