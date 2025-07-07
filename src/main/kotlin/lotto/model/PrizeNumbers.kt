package lotto.model

class PrizeNumbers(val winningNumbers: List<LottoNumber>, val bonusNumber: LottoNumber) : LottoTicket(winningNumbers)
