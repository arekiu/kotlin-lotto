package lotto

class Lotto(val lottoNumbers: List<Int>) {
    init {
        require(lottoNumbers.count() == 6)
        require(numbersAreInRange(lottoNumbers))
        require(numbersAreNotDuplicated(lottoNumbers))
    }

    fun getNumbers(): List<Int> {
        return lottoNumbers
    }

    private fun numbersAreInRange(lottoNumbers: List<Int>): Boolean {
        return lottoNumbers.all { it in 1..45 }
    }

    private fun numbersAreNotDuplicated(lottoNumbers: List<Int>): Boolean {
        return lottoNumbers.count() == lottoNumbers.toSet().count()
    }
}
