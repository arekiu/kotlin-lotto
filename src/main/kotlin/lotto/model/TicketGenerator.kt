package lotto.model

class TicketGenerator() {

    private fun generateLottoNumbers(numbers: List<Int>) = numbers.map { number -> LottoNumber.from(number) }

    fun createLottoTicket(numbers: List<Int>): LottoTicket {
        return LottoTicket(generateLottoNumbers(numbers))
    }
}
