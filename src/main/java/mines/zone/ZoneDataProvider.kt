package mines.zone

interface ZoneDataProvider {
    fun state(): ZoneState
    fun value(): ZoneValue
    fun isMine(): Boolean
    fun isFlagged(): Boolean
    fun isRevealed(): Boolean
}
