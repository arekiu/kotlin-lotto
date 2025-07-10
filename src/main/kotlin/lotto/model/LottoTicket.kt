package lotto.model

class LottoTicket(
    numbersForLotto: List<Int>,
    var numberOfHits: Int = 0,
    var hasBonus: Boolean = false,
) {
    val lottoNumbers: List<LottoNumber>

    init {
        require(numbersForLotto.count() == 6)
        require(numbersForLotto.distinct().size == 6)
        require(numbersForLotto.all { it in 1..45 })

        lottoNumbers = numbersForLotto.map { LottoNumber.from(it) }
    }

    fun compareTicket(prizeNumbers: PrizeNumbers) {
        numberOfHits = prizeNumbers.winningNumbersTicket.lottoNumbers.count { it in lottoNumbers }
        if (numberOfHits == 5) {
            hasBonus = prizeNumbers.bonusNumber in lottoNumbers
        }
    }
}
