package mines.zone

class OnZoneStateChangedListenerFactory {
    fun newInstance(): OnZoneStateChangedListener {
        return object : OnZoneStateChangedListener {}
    }
}
