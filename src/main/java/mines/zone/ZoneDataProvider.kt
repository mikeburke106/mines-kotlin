package mines.zone

interface ZoneDataProvider {
    val value: ZoneValue
    fun isMine(): Boolean
    fun adjacentMines(): Int
}
