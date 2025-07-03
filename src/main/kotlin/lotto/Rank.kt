package lotto

enum class Rank(val countOfMatch: Int, val winningMoney: Int, val hasBonus: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false),
    ;

    companion object {
        fun valueOf(
            countOfMatch: Int,
            matchBonus: Boolean,
        ): Rank {
            return values().find { it ->
                (it.countOfMatch == countOfMatch && it.hasBonus == matchBonus)
            } ?: MISS
        }
    }
}
