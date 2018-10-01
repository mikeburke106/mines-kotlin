package mines.zone

class ZoneStateMachineFactory(private val initialState: ZoneState,
                              private val onZoneStateChangedListenerFactory: OnZoneStateChangedListenerFactory) {
    fun newInstance(zoneDataProvider: ZoneDataProvider): ZoneStateMachine {
        return ZoneStateMachine(zoneDataProvider, initialState, onZoneStateChangedListenerFactory.newInstance())
    }
}
