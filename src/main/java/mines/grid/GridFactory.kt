package mines.grid

import mines.zone.ZoneState

class GridFactory {

    data class Filter(val x: Int, val y: Int, val zoneState: ZoneState)

    fun newInstance(width: Int, height: Int, numOfMines: Int, filters: List<Filter> = listOf()): Grid{
        return Grid(width, height)
    }

}