package mines.zone

interface OnZoneStateChangedListener {
    fun onZoneStateChanged(oldState: ZoneState, newState: ZoneState) {
        // do nothing by default
    }
}
