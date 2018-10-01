package mines.zone

data class Zone(override val value: ZoneValue = ZoneValue.ZERO) : ZoneDataProvider {
    override fun adjacentMines(): Int {
        return value.adjacent
    }

    override fun isMine(): Boolean {
        return value == ZoneValue.MINE
    }
}
