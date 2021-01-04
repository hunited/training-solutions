package week10.d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    public void testHiking() {
        Position pos1 = new Position(10);
        Position pos2 = new Position(47.497913, 19.040236, 20);
        Position pos3 = new Position(15);
        Position pos4 = new Position(18);
        Position pos5 = new Position(18.5);
        Position pos6 = new Position(0);
        Position pos7 = new Position(34);
        Position pos8 = new Position(36);
        Hiking hiking = new Hiking();
        assertEquals(49.5, hiking.getPlusElevation(List.of(pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8)));
    }

    @Test
    public void testHikingNullPointer() {
        Exception ex = assertThrows(NullPointerException.class, () -> new Hiking().getPlusElevation(List.of()));
        assertEquals("A lista nem lehet üres", ex.getMessage());
    }

    @Test
    public void testHikingIllegalArgument() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Hiking().getPlusElevation(List.of(new Position(10))));
        assertEquals("A lista legalább két elemű legyen", ex.getMessage());
    }

}
