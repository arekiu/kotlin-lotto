package lotto.model

class LottoTicket(
    val lottoNumbers: List<LottoNumber>,
    var numberOfHits: Int = 0,
    var hasBonus: Boolean = false
) {
    init {
        require(lottoNumbers.count() == 6)
        require(numbersAreNotDuplicated(lottoNumbers))
    }

    private fun numbersAreNotDuplicated(lottoNumbers: List<LottoNumber>): Boolean {
        return lottoNumbers.count() == lottoNumbers.toSet().count()
    }

    fun compareTicket(prizeNumbers: PrizeNumbers) {
        numberOfHits = prizeNumbers.winningNumbersTicket.lottoNumbers.count { it in lottoNumbers }
        if (numberOfHits == 5) {
            hasBonus = prizeNumbers.bonusNumber in lottoNumbers
        }
    }

}
