package mines.grid

import org.junit.Assert
import org.junit.Test

class GridTest {
    @Test(expected = IllegalStateException::class)
    fun checkWidth_invalidNegative() {
        Grid(-1, 2)
    }

    @Test(expected = IllegalStateException::class)
    fun checkHeight_invalidNegative() {
        Grid(2, -1)
    }

    @Test(expected = IllegalStateException::class)
    fun checkMinePositions_moreMinesThanPositions() {
        Grid(1, 1, listOf(0, 1))
    }

    @Test(expected = IllegalStateException::class)
    fun checkMinePositions_invalidIndexNegative() {
        Grid(2, 2, listOf(-1, 0))
    }

    @Test(expected = IllegalStateException::class)
    fun checkMinePositions_invalidIndexGreaterThanSize() {
        Grid(2, 2, listOf(0, 1, 4))
    }

    @Test(expected = IllegalStateException::class)
    fun checkIsMine_invalidIndexNegative() {
        Grid(2, 2).isMine(-1)
    }

    @Test(expected = IllegalStateException::class)
    fun checkIsMine_invalidIndexGreaterThanSize() {
        Grid(2, 2).isMine(6)
    }

    @Test(expected = IllegalStateException::class)
    fun checkNumOfAdjacentMines_invalidIndexNegative() {
        Grid(2, 2).numOfAdjacentMines(-1)
    }

    @Test(expected = IllegalStateException::class)
    fun checkNumOfAdjacentMines_invalidIndexGreaterThanSize() {
        Grid(2, 2).numOfAdjacentMines(6)
    }

    @Test(expected = IllegalStateException::class)
    fun checkGetAdjacentZoneValues_invalidIndexNegative() {
        Grid(2, 2).getAdjacentZoneValues(-1)
    }

    @Test(expected = IllegalStateException::class)
    fun checkGetAdjacentZoneValues_invalidIndexGreaterThanSize() {
        Grid(2, 2).getAdjacentZoneValues(6)
    }

    @Test
    fun checkIsMine_uninitialized() {
        val grid = Grid(1, 1)
        Assert.assertFalse(grid.isMine(0))
    }

    @Test
    fun checkNumMines_uninitialized() {
        val grid = Grid(1, 1)
        Assert.assertEquals(0, grid.getNumOfMines())
    }

    @Test
    fun checkNumMines_initialized() {
        val grid = Grid(2, 2, listOf(0, 1, 2, 3))
        Assert.assertEquals(4, grid.getNumOfMines())
    }

    @Test
    fun checkBoundaries_1x1Grid() {
        val grid = Grid(1, 1)

        // all boundaries, index = 0
        Assert.assertTrue(grid.isBottomBoundary(0))
        Assert.assertTrue(grid.isTopBoundary(0))
        Assert.assertTrue(grid.isLeftBoundary(0))
        Assert.assertTrue(grid.isRightBoundary(0))
    }

    @Test
    fun checkBoundaries_2x2Grid() {
        val grid = Grid(2, 2)

        // top left index = 0
        Assert.assertTrue(grid.isTopBoundary(0))
        Assert.assertTrue(grid.isLeftBoundary(0))
        Assert.assertFalse(grid.isBottomBoundary(0))
        Assert.assertFalse(grid.isRightBoundary(0))

        //top right index = 1
        Assert.assertTrue(grid.isTopBoundary(1))
        Assert.assertTrue(grid.isRightBoundary(1))
        Assert.assertFalse(grid.isBottomBoundary(1))
        Assert.assertFalse(grid.isLeftBoundary(1))

        // bottom left index = 2
        Assert.assertTrue(grid.isBottomBoundary(2))
        Assert.assertTrue(grid.isLeftBoundary(2))
        Assert.assertFalse(grid.isTopBoundary(2))
        Assert.assertFalse(grid.isRightBoundary(2))

        // bottom right index = 3
        Assert.assertTrue(grid.isBottomBoundary(3))
        Assert.assertTrue(grid.isRightBoundary(3))
        Assert.assertFalse(grid.isTopBoundary(3))
        Assert.assertFalse(grid.isLeftBoundary(3))
    }

    @Test
    fun checkBoundaries_3x3Grid() {
        val grid = Grid(3, 3)

        // top left index = 0
        Assert.assertTrue(grid.isTopBoundary(0))
        Assert.assertTrue(grid.isLeftBoundary(0))
        Assert.assertFalse(grid.isBottomBoundary(0))
        Assert.assertFalse(grid.isRightBoundary(0))

        // top index = 1
        Assert.assertTrue(grid.isTopBoundary(1))
        Assert.assertFalse(grid.isLeftBoundary(1))
        Assert.assertFalse(grid.isBottomBoundary(1))
        Assert.assertFalse(grid.isRightBoundary(1))

        //top right index = 2
        Assert.assertTrue(grid.isTopBoundary(2))
        Assert.assertTrue(grid.isRightBoundary(2))
        Assert.assertFalse(grid.isBottomBoundary(2))
        Assert.assertFalse(grid.isLeftBoundary(2))

        // left index = 3
        Assert.assertTrue(grid.isLeftBoundary(3))
        Assert.assertFalse(grid.isBottomBoundary(3))
        Assert.assertFalse(grid.isTopBoundary(3))
        Assert.assertFalse(grid.isRightBoundary(3))

        // middle index = 4
        Assert.assertFalse(grid.isBottomBoundary(4))
        Assert.assertFalse(grid.isRightBoundary(4))
        Assert.assertFalse(grid.isTopBoundary(4))
        Assert.assertFalse(grid.isLeftBoundary(4))

        // right index = 5
        Assert.assertTrue(grid.isRightBoundary(5))
        Assert.assertFalse(grid.isBottomBoundary(5))
        Assert.assertFalse(grid.isTopBoundary(5))
        Assert.assertFalse(grid.isLeftBoundary(5))

        // bottom left index = 6
        Assert.assertTrue(grid.isBottomBoundary(6))
        Assert.assertTrue(grid.isLeftBoundary(6))
        Assert.assertFalse(grid.isTopBoundary(6))
        Assert.assertFalse(grid.isRightBoundary(6))

        // bottom index = 7
        Assert.assertTrue(grid.isBottomBoundary(7))
        Assert.assertFalse(grid.isRightBoundary(7))
        Assert.assertFalse(grid.isTopBoundary(7))
        Assert.assertFalse(grid.isLeftBoundary(7))

        // bottom right index = 8
        Assert.assertTrue(grid.isBottomBoundary(8))
        Assert.assertTrue(grid.isRightBoundary(8))
        Assert.assertFalse(grid.isTopBoundary(8))
        Assert.assertFalse(grid.isLeftBoundary(8))
    }
}
