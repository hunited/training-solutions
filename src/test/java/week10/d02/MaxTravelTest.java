package week10.d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    void getMaxIndex() {
        assertEquals(4, new MaxTravel().getMaxIndex(List.of(12, 12, 0, 3, 4, 4)));
        assertEquals(0, new MaxTravel().getMaxIndex(List.of(0, 0, 0, 3, 4, 4)));
        assertEquals(12, new MaxTravel().getMaxIndex(List.of(12)));
        assertEquals(12, new MaxTravel().getMaxIndex(List.of(12, 12, 0, 3, 4, 4, 12)));
    }

    @Test
    void getMaxIndexNull() {
        Exception ex = assertThrows(NullPointerException.class, () -> new MaxTravel().getMaxIndex(null));
        assertEquals("Nincs utas!", ex.getMessage());
    }

    @Test
    void getMaxIndexEmpty() {
        Exception ex = assertThrows(NullPointerException.class, () -> new MaxTravel().getMaxIndex(List.of()));
        assertEquals("Nincs utas!", ex.getMessage());
    }

    @Test
    void getMaxIndexTooManyStops() {
        Exception ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> new MaxTravel().getMaxIndex(List.of(12, 12, 0, 3, 4, 4, 30)));
        assertEquals("Csak 30 megálló lehet!", ex.getMessage());
    }
}