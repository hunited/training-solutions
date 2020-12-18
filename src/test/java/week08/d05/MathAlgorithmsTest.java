package week08.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    public void testCalculate() {
        assertEquals(41, new MathAlgorithms().greatestCommonDivisor(41, 82));
        assertEquals(3, new MathAlgorithms().greatestCommonDivisor(6, 3));
        assertEquals(1, new MathAlgorithms().greatestCommonDivisor(1, 1));
        assertEquals(12, new MathAlgorithms().greatestCommonDivisor(12, 12));
        assertEquals(1, new MathAlgorithms().greatestCommonDivisor(2, 1));
        assertEquals(42585, new MathAlgorithms().greatestCommonDivisor(170340, 42585));
        assertEquals(1, new MathAlgorithms().greatestCommonDivisor(3, 5));
    }

    @Test
    public void testCalculateZero() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new MathAlgorithms().greatestCommonDivisor(0, 10));
        assertEquals("Nem lehet nulla vagy nagatív.", ex.getMessage());
    }

    @Test
    public void testCalculateNegative() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new MathAlgorithms().greatestCommonDivisor(-10, 10));
        assertEquals("Nem lehet nulla vagy nagatív.", ex.getMessage());
    }

}