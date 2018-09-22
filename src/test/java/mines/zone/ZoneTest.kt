package mines.zone

import com.nhaarman.mockito_kotlin.*
import org.junit.Assert.assertEquals
import org.junit.Test

class ZoneTest {
    private val mockListener: OnZoneStateChangedListener = mock()

    @Test
    fun toggleFlag_fromCoveredState() {
        val zone = Zone(initialState = ZoneState.COVERED)
        zone.toggleFlag()
        assertEquals(ZoneState.FLAGGED, zone.state())
    }

    @Test
    fun toggleFlag_fromFlaggedState() {
        val zone = Zone(initialState = ZoneState.FLAGGED)
        zone.toggleFlag()
        assertEquals(ZoneState.COVERED, zone.state())
    }

    @Test
    fun toggleFlag_fromRevealedState() {
        val zone = Zone(initialState = ZoneState.REVEALED)
        zone.toggleFlag()
        assertEquals(ZoneState.REVEALED, zone.state())
    }

    @Test
    fun toggleFlag_fromExplodedState() {
        val zone = Zone(initialState = ZoneState.EXPLODED)
        zone.toggleFlag()
        assertEquals(ZoneState.EXPLODED, zone.state())
    }

    @Test
    fun reveal_fromCoveredState() {
        val zone = Zone(initialState = ZoneState.COVERED)
        zone.reveal()
        assertEquals(ZoneState.REVEALED, zone.state())
    }

    @Test
    fun reveal_fromFlaggedState() {
        val zone = Zone(initialState = ZoneState.FLAGGED)
        zone.reveal()
        assertEquals(ZoneState.FLAGGED, zone.state())
    }

    @Test
    fun reveal_fromRevealedState() {
        val zone = Zone(initialState = ZoneState.REVEALED)
        zone.reveal()
        assertEquals(ZoneState.REVEALED, zone.state())
    }

    @Test
    fun reveal_fromExplodedState() {
        val zone = Zone(initialState = ZoneState.EXPLODED)
        zone.reveal()
        assertEquals(ZoneState.EXPLODED, zone.state())
    }

    @Test
    fun valueZero_isNotMine() {
        val zone = Zone(value = ZoneValue.ZERO)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueOne_isNotMine() {
        val zone = Zone(value = ZoneValue.ONE)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueTwo_isNotMine() {
        val zone = Zone(value = ZoneValue.TWO)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueThree_isNotMine() {
        val zone = Zone(value = ZoneValue.THREE)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueFour_isNotMine() {
        val zone = Zone(value = ZoneValue.FOUR)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueFive_isNotMine() {
        val zone = Zone(value = ZoneValue.FIVE)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueSix_isNotMine() {
        val zone = Zone(value = ZoneValue.SIX)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueSeven_isNotMine() {
        val zone = Zone(value = ZoneValue.SEVEN)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueEight_isNotMine() {
        val zone = Zone(value = ZoneValue.EIGHT)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueMine_isMine() {
        val zone = Zone(value = ZoneValue.MINE)
        assertEquals(true, zone.isMine())
    }

    @Test
    fun stateCovered_isNotFlagged() {
        val zone = Zone(initialState = ZoneState.COVERED)
        assertEquals(false, zone.isFlagged())
    }

    @Test
    fun stateRevealed_isNotFlagged() {
        val zone = Zone(initialState = ZoneState.REVEALED)
        assertEquals(false, zone.isFlagged())
    }

    @Test
    fun stateExploded_isNotFlagged() {
        val zone = Zone(initialState = ZoneState.EXPLODED)
        assertEquals(false, zone.isFlagged())
    }

    @Test
    fun stateFlagged_isFlagged() {
        val zone = Zone(initialState = ZoneState.FLAGGED)
        assertEquals(true, zone.isFlagged())
    }

    @Test
    fun stateCovered_isNotRevealed() {
        val zone = Zone(initialState = ZoneState.COVERED)
        assertEquals(false, zone.isRevealed())
    }

    @Test
    fun stateRevealed_isRevealed() {
        val zone = Zone(initialState = ZoneState.REVEALED)
        assertEquals(true, zone.isRevealed())
    }

    @Test
    fun stateExploded_isNotRevealed() {
        val zone = Zone(initialState = ZoneState.EXPLODED)
        assertEquals(false, zone.isRevealed())
    }

    @Test
    fun stateFlagged_isNotRevealed() {
        val zone = Zone(initialState = ZoneState.FLAGGED)
        assertEquals(false, zone.isRevealed())
    }

    @Test
    fun toggleFlagFromCovered_doesTriggerListener() {
        val zone = Zone(initialState = ZoneState.COVERED, zoneStateChangedListener = mockListener)
        zone.toggleFlag()
        verify(mockListener, times(1)).onZoneStateChanged(ZoneState.COVERED, ZoneState.FLAGGED)
    }

    @Test
    fun toggleFlagFromRevealed_doesNotTriggerListener() {
        val zone = Zone(initialState = ZoneState.REVEALED, zoneStateChangedListener = mockListener)
        zone.toggleFlag()
        verify(mockListener, never()).onZoneStateChanged(any(), any())
    }

    @Test
    fun toggleFlagFromFlagged_doesTriggerListener() {
        val zone = Zone(initialState = ZoneState.FLAGGED, zoneStateChangedListener = mockListener)
        zone.toggleFlag()
        verify(mockListener, times(1)).onZoneStateChanged(ZoneState.FLAGGED, ZoneState.COVERED)
    }

    @Test
    fun toggleFlagFromExploded_doesNotTriggerListener() {
        val zone = Zone(initialState = ZoneState.EXPLODED, zoneStateChangedListener = mockListener)
        zone.toggleFlag()
        verify(mockListener, never()).onZoneStateChanged(any(), any())
    }

    @Test
    fun revealFromExploded_doesNotTriggerListener() {
        val zone = Zone(initialState = ZoneState.EXPLODED, zoneStateChangedListener = mockListener)
        zone.reveal()
        verify(mockListener, never()).onZoneStateChanged(any(), any())
    }

    @Test
    fun revealFromRevealed_doesNotTriggerListener() {
        val zone = Zone(initialState = ZoneState.REVEALED, zoneStateChangedListener = mockListener)
        zone.reveal()
        verify(mockListener, never()).onZoneStateChanged(any(), any())
    }

    @Test
    fun revealFromFlagged_doesNotTriggerListener() {
        val zone = Zone(initialState = ZoneState.FLAGGED, zoneStateChangedListener = mockListener)
        zone.reveal()
        verify(mockListener, never()).onZoneStateChanged(any(), any())
    }

    @Test
    fun revealFromCovered_doesTriggerListener() {
        val zone = Zone(initialState = ZoneState.COVERED, zoneStateChangedListener = mockListener)
        zone.reveal()
        verify(mockListener, times(1)).onZoneStateChanged(ZoneState.COVERED, ZoneState.REVEALED)
    }
}
