package mines.grid

import mines.zone.ZoneValue

class Grid(private val width: Int,
           private val height: Int,
           private val minePositions: List<Int> = listOf()) {

    private val size = width * height

    init {
        check(width > 0) {
            "width must be greater than 0"
        }

        check(height > 0) {
            "height must be greater than 0"
        }

        check(minePositions.size <= size) {
            "too many mines for grid size"
        }

        for (value in minePositions) {
            check(value in 0 until size) {
                "invalid index for mine position $value"
            }
        }
    }

    fun getNumOfMines(): Int {
        return minePositions.size
    }

    fun isMine(index: Int): Boolean {
        checkIndex(index)
        return minePositions.contains(index)
    }

    fun numOfAdjacentMines(index: Int): Int {
        checkIndex(index)
        return -1
    }

    fun getAdjacentZoneValues(index: Int): Map<Int, ZoneValue> {
        checkIndex(index)
        return mapOf()
    }

    private fun checkIndex(index: Int) {
        check(index in 0 until size) {
            "index $index out of bounds"
        }
    }

    fun isLeftBoundary(index: Int): Boolean {
        checkIndex(index)
        return index % width == 0
    }

    fun isRightBoundary(index: Int): Boolean {
        checkIndex(index)
        return index % width == (width - 1)
    }

    fun isTopBoundary(index: Int): Boolean {
        checkIndex(index)
        return index in 0 until width
    }

    fun isBottomBoundary(index: Int): Boolean {
        checkIndex(index)
        return index in (width * (height - 1)) until size
    }
}
