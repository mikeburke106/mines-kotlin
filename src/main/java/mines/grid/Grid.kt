package mines.grid

import mines.zone.ZoneValue

class Grid(val width: Int,
           val height: Int,
           private val minePositions: List<Int> = listOf()) {
    private val size = width * height

    fun getNumOfMines(): Int {
        return minePositions.size
    }

    fun isMine(index: Int): Boolean {
        return minePositions.contains(index)
    }

    fun numOfAdjacentMines(index: Int): Int {
        return -1
    }

    fun getAdjacentZoneValues(index: Int): Map<Int, ZoneValue> {
        return mapOf()
    }

    fun isLeftBoundary(index: Int): Boolean {
        return index % width == 0
    }

    fun isRightBoundary(index: Int): Boolean {
        return index % width == (width - 1)
    }

    fun isTopBoundary(index: Int): Boolean {
        return index in 0..(width - 1)
    }

    fun isBottomBoundary(index: Int): Boolean {
        return index in (width * (height-1))..(size-1)
    }
}
