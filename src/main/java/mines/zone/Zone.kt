package mines.zone

// TODO: Zone should not know about its own state.
// TODO: Should zone know its "index"?  Seems like no...

class Zone(private val value: ZoneValue = ZoneValue.ZERO,
           initialState: ZoneState = ZoneState.COVERED,
           zoneStateChangedListener: OnZoneStateChangedListener = object : OnZoneStateChangedListener {})
    : ZoneControl, ZoneDataProvider {

    private val stateMachine = StateMachine(this, initialState, zoneStateChangedListener)

    override fun toggleFlag() {
        stateMachine.toggleFlag()
    }

    override fun reveal() {
        stateMachine.reveal()
    }

    override fun state(): ZoneState {
        return stateMachine.state()
    }

    override fun value(): ZoneValue {
        return value
    }

    override fun isMine(): Boolean {
        return value == ZoneValue.MINE
    }

    override fun isFlagged(): Boolean {
        return stateMachine.state() == ZoneState.FLAGGED
    }

    override fun isRevealed(): Boolean {
        return stateMachine.state() == ZoneState.REVEALED
    }

    private class StateMachine(private val zoneDataProvider: ZoneDataProvider,
                               initialState: ZoneState,
                               private val zoneStateChangedListener: OnZoneStateChangedListener) : ZoneControl {

        private var zoneState = initialState

        fun state(): ZoneState {
            return this.zoneState
        }

        override fun toggleFlag() {
            val oldState = this.zoneState

            if (oldState == ZoneState.COVERED) {
                this.zoneState = ZoneState.FLAGGED
                this.zoneStateChangedListener.onZoneStateChanged(oldState, this.zoneState)
            } else if (oldState == ZoneState.FLAGGED) {
                this.zoneState = ZoneState.COVERED
                this.zoneStateChangedListener.onZoneStateChanged(oldState, this.zoneState)
            }
        }

        override fun reveal() {
            val isMine = this.zoneDataProvider.isMine()
            val oldState = this.zoneState

            if (oldState == ZoneState.COVERED) {
                if (isMine) {
                    this.zoneState = ZoneState.EXPLODED
                } else {
                    this.zoneState = ZoneState.REVEALED
                }
                this.zoneStateChangedListener.onZoneStateChanged(oldState, this.zoneState)
            }
        }
    }
}
