package lotto

class Lotto(val lottoNumbers: List<Int>) {
    init {
        require(lottoNumbers.count() == 6)
        require(isInRange(lottoNumbers))
        require(isDuplicated(lottoNumbers))
    }

    fun getNumbers(): List<Int> {
        return lottoNumbers
    }

    private fun isInRange(lottoNumbers: List<Int>): Boolean {
        return lottoNumbers.all { it in 1..45 }
    }

    private fun isDuplicated(lottoNumbers: List<Int>): Boolean {
        return lottoNumbers.count() == lottoNumbers.toSet().count()
    }
}
