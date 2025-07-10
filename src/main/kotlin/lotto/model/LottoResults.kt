package lotto.model

class LottoResults(private val winsByRank: Map<Rank, Int>) {
    fun obtainWinsForRank(rank: Rank) = winsByRank[rank] ?: 0

    fun calculateTotalPrize(): Int =
        winsByRank.entries.sumOf { (rank, count) ->
            rank.winningMoney * count
        }
}
