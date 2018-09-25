package mines.grid

import org.junit.Assert
import org.junit.Test

class GridTest {
    @Test
    fun checkBoundaries_1x1Grid() {
        val grid = Grid(1, 1)
        Assert.assertTrue(grid.isBottomBoundary(0))
        Assert.assertTrue(grid.isTopBoundary(0))
        Assert.assertTrue(grid.isLeftBoundary(0))
        Assert.assertTrue(grid.isRightBoundary(0))
    }
}