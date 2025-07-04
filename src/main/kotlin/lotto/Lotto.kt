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
        lottoNumbers.forEach { number ->
            if (number !in 1..45) {
                return false
            }
        }
        return true
    }

    private fun isDuplicated(lottoNumbers: List<Int>): Boolean {
        return lottoNumbers.count() == lottoNumbers.toSet().count()
    }
}
