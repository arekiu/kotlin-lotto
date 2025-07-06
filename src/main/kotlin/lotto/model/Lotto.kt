package lotto.model

class Lotto(
    val lottoNumbers: List<Int>,
    var hasBonus: Boolean = false,
    var numberOfHits: Int = 0
) {
    init {
        require(lottoNumbers.count() == 6)
        require(numbersAreInRange(lottoNumbers))
        require(numbersAreNotDuplicated(lottoNumbers))
    }

    private fun numbersAreInRange(lottoNumbers: List<Int>): Boolean {
        return lottoNumbers.all { it in 1..45 }
    }

    private fun numbersAreNotDuplicated(lottoNumbers: List<Int>): Boolean {
        return lottoNumbers.count() == lottoNumbers.toSet().count()
    }

    fun compareTicket(winningNumbers: List<Int>, bonusNumber: Int) {
        compareTicketToWinningNumbers(winningNumbers)
        if (numberOfHits == 5) compareTicketToBonusNumber(bonusNumber)
    }

    private fun compareTicketToWinningNumbers(
        winningNumbers: List<Int>,
    ) {
        numberOfHits = winningNumbers.count { it in lottoNumbers }
    }

    private fun compareTicketToBonusNumber(
        bonusNumber: Int,
    ) {
        hasBonus = bonusNumber in lottoNumbers
    }
}
