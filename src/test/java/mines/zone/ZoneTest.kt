package mines.zone

import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert.assertEquals
import org.junit.Test

class ZoneTest {
    private val mockListener: OnZoneStateChangedListener = mock()

    @Test
    fun valueZero_isNotMine() {
        val zone = Zone(ZoneValue.ZERO)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueOne_isNotMine() {
        val zone = Zone(ZoneValue.ONE)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueTwo_isNotMine() {
        val zone = Zone(ZoneValue.TWO)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueThree_isNotMine() {
        val zone = Zone(ZoneValue.THREE)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueFour_isNotMine() {
        val zone = Zone(ZoneValue.FOUR)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueFive_isNotMine() {
        val zone = Zone(ZoneValue.FIVE)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueSix_isNotMine() {
        val zone = Zone(ZoneValue.SIX)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueSeven_isNotMine() {
        val zone = Zone(ZoneValue.SEVEN)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueEight_isNotMine() {
        val zone = Zone(ZoneValue.EIGHT)
        assertEquals(false, zone.isMine())
    }

    @Test
    fun valueMine_isMine() {
        val zone = Zone(ZoneValue.MINE)
        assertEquals(true, zone.isMine())
    }
}
