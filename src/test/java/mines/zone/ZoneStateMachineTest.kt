package mines.zone

import com.nhaarman.mockito_kotlin.*
import org.junit.Assert
import org.junit.Test

class ZoneStateMachineTest {
    private val mockZoneDataProvider: ZoneDataProvider = mock()
    private val mockZoneStateChangedListener: OnZoneStateChangedListener = mock()

    @Test
    fun toggleFlag_fromCoveredState() {
        val zone = ZoneStateMachine(zoneDataProvider = mockZoneDataProvider,
                initialState = ZoneState.COVERED)
        zone.toggleFlag()
        Assert.assertTrue(zone.isInState(ZoneState.FLAGGED))
    }

    @Test
    fun toggleFlag_fromFlaggedState() {
        val zone = ZoneStateMachine(zoneDataProvider = mockZoneDataProvider,
                initialState = ZoneState.FLAGGED)
        zone.toggleFlag()
        Assert.assertTrue(zone.isInState(ZoneState.COVERED))
    }

    @Test
    fun toggleFlag_fromRevealedState() {
        val zone = ZoneStateMachine(zoneDataProvider = mockZoneDataProvider,
                initialState = ZoneState.REVEALED)
        zone.toggleFlag()
        Assert.assertTrue(zone.isInState(ZoneState.REVEALED))
    }

    @Test
    fun toggleFlag_fromExplodedState() {
        val zone = ZoneStateMachine(zoneDataProvider = mockZoneDataProvider,
                initialState = ZoneState.EXPLODED)
        zone.toggleFlag()
        Assert.assertTrue(zone.isInState(ZoneState.EXPLODED))
    }

    @Test
    fun reveal_fromCoveredState() {
        val zone = ZoneStateMachine(zoneDataProvider = mockZoneDataProvider,
                initialState = ZoneState.COVERED)
        zone.reveal()
        Assert.assertTrue(zone.isInState(ZoneState.REVEALED))
    }

    @Test
    fun reveal_fromFlaggedState() {
        val zone = ZoneStateMachine(zoneDataProvider = mockZoneDataProvider,
                initialState = ZoneState.FLAGGED)
        zone.reveal()
        Assert.assertTrue(zone.isInState(ZoneState.FLAGGED))
    }

    @Test
    fun reveal_fromRevealedState() {
        val zone = ZoneStateMachine(zoneDataProvider = mockZoneDataProvider,
                initialState = ZoneState.REVEALED)
        zone.reveal()
        Assert.assertTrue(zone.isInState(ZoneState.REVEALED))
    }

    @Test
    fun reveal_fromExplodedState() {
        val zone = ZoneStateMachine(zoneDataProvider = mockZoneDataProvider,
                initialState = ZoneState.EXPLODED)
        zone.reveal()
        Assert.assertTrue(zone.isInState(ZoneState.EXPLODED))
    }

    @Test
    fun toggleFlagFromCovered_doesTriggerListener() {
        val zone = ZoneStateMachine(mockZoneDataProvider, ZoneState.COVERED,
                mockZoneStateChangedListener)
        zone.toggleFlag()
        verify(mockZoneStateChangedListener, times(1))
                .onZoneStateChanged(ZoneState.COVERED, ZoneState.FLAGGED)
    }

    @Test
    fun toggleFlagFromRevealed_doesNotTriggerListener() {
        val zone = ZoneStateMachine(mockZoneDataProvider, ZoneState.REVEALED,
                mockZoneStateChangedListener)
        zone.toggleFlag()
        verify(mockZoneStateChangedListener, never()).onZoneStateChanged(any(), any())
    }

    @Test
    fun toggleFlagFromFlagged_doesTriggerListener() {
        val zone = ZoneStateMachine(mockZoneDataProvider, ZoneState.FLAGGED,
                mockZoneStateChangedListener)
        zone.toggleFlag()
        verify(mockZoneStateChangedListener, times(1))
                .onZoneStateChanged(ZoneState.FLAGGED, ZoneState.COVERED)
    }

    @Test
    fun toggleFlagFromExploded_doesNotTriggerListener() {
        val zone = ZoneStateMachine(mockZoneDataProvider, ZoneState.EXPLODED,
                mockZoneStateChangedListener)
        zone.toggleFlag()
        verify(mockZoneStateChangedListener, never()).onZoneStateChanged(any(), any())
    }

    @Test
    fun revealFromExploded_doesNotTriggerListener() {
        val zone = ZoneStateMachine(mockZoneDataProvider, ZoneState.EXPLODED,
                mockZoneStateChangedListener)
        zone.reveal()
        verify(mockZoneStateChangedListener, never()).onZoneStateChanged(any(), any())
    }

    @Test
    fun revealFromRevealed_doesNotTriggerListener() {
        val zone = ZoneStateMachine(mockZoneDataProvider, ZoneState.REVEALED,
                mockZoneStateChangedListener)
        zone.reveal()
        verify(mockZoneStateChangedListener, never()).onZoneStateChanged(any(), any())
    }

    @Test
    fun revealFromFlagged_doesNotTriggerListener() {
        val zone = ZoneStateMachine(mockZoneDataProvider, ZoneState.FLAGGED,
                mockZoneStateChangedListener)
        zone.reveal()
        verify(mockZoneStateChangedListener, never()).onZoneStateChanged(any(), any())
    }

    @Test
    fun revealFromCovered_doesTriggerListener() {
        val zone = ZoneStateMachine(mockZoneDataProvider, ZoneState.COVERED,
                mockZoneStateChangedListener)
        zone.reveal()
        verify(mockZoneStateChangedListener, times(1))
                .onZoneStateChanged(ZoneState.COVERED, ZoneState.REVEALED)
    }
}
