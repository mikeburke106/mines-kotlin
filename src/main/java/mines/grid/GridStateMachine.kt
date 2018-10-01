package mines.grid

import mines.zone.ZoneDataProvider
import mines.zone.ZoneStateMachine
import mines.zone.ZoneStateMachineFactory

class GridStateMachine(zoneDataProviderList: List<ZoneDataProvider>,
                       zoneStateMachineFactory: ZoneStateMachineFactory
) {
    private val zoneStateMachineList: List<ZoneStateMachine>

    init {
        val builderList: MutableList<ZoneStateMachine> = ArrayList()
        for (i in (0 until zoneDataProviderList.size)) {
            val zoneStateMachine = zoneStateMachineFactory.newInstance(zoneDataProviderList[i])
            builderList.add(zoneStateMachine)
        }

        zoneStateMachineList = ArrayList(builderList)
    }

    fun toggleFlag(index: Int) {
        zoneStateMachineList[index].toggleFlag()
    }

    fun reveal(index: Int) {
        zoneStateMachineList[index].reveal()
    }
}
