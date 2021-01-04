package week10.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    public void testPositionConstructorWithOneParam() {
        Position pos = new Position(10);
        assertEquals(0.0, pos.getPosX());
        assertEquals(0.0, pos.getPosY());
        assertEquals(10.0, pos.getPosZ());
    }

    @Test
    public void testPositionConstructorWithThreeParam() {
        Position pos = new Position(47.497913, 19.040236, 20);
        assertEquals(47.497913, pos.getPosX());
        assertEquals(19.040236, pos.getPosY());
        assertEquals(20.0, pos.getPosZ());
    }

}
