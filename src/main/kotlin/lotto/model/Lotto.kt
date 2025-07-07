package lotto.model

class Lotto(
    val lottoNumbers: List<Int>,
    var numberOfHits : Int = 0,
    var hasBonus : Boolean = false
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
        numberOfHits = compareTicketToWinningNumbers(winningNumbers)
        if (numberOfHits == 5){
            hasBonus = compareTicketToBonusNumber(bonusNumber)
        }
    }

    private fun compareTicketToWinningNumbers(
        winningNumbers: List<Int>,
    ) = winningNumbers.count { it in lottoNumbers }

    private fun compareTicketToBonusNumber(
        bonusNumber: Int,
    ) = bonusNumber in lottoNumbers
}
