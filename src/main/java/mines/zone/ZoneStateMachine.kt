package mines.zone

import kotlin.properties.Delegates

class ZoneStateMachine(private val zoneDataProvider: ZoneDataProvider,
                       initialState: ZoneState = ZoneState.COVERED,
                       private val zoneStateChangedListener: OnZoneStateChangedListener = object : OnZoneStateChangedListener {}
) : ZoneControl, ZoneStateInspector {

    private var zoneState by Delegates.observable(initialState) { _, old, new ->
        zoneStateChangedListener.onZoneStateChanged(old, new)
    }

    override fun isInState(state: ZoneState): Boolean {
        return this.zoneState == state
    }

    override fun toggleFlag() {
        when (this.zoneState) {
            ZoneState.COVERED -> this.zoneState = ZoneState.FLAGGED
            ZoneState.FLAGGED -> this.zoneState = ZoneState.COVERED
            else -> {
            }
        }
    }

    override fun reveal() {
        if (zoneState == ZoneState.COVERED) {
            this.zoneState = when (this.zoneDataProvider.isMine()) {
                true -> ZoneState.EXPLODED
                false -> ZoneState.REVEALED
            }
        }
    }
}
