package mines.zone

interface ZoneStateInspector {
    fun isInState(state: ZoneState): Boolean
}
