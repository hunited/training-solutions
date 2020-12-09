package week07d03;

import org.junit.jupiter.api.Test;
import week07d01.MathAlgorithms;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NumberListTest {

    @Test
    public void testNumsTrue() {
        assertTrue(NumberList.isIncreasing(Arrays.asList(1, 2, 3, 4, 4, 5)));
    }

    @Test
    public void testNumsFalse() {
        assertFalse(NumberList.isIncreasing(Arrays.asList(1, 2, 3, 2, 4, 5)));
    }

    @Test
    public void testNumsNonValid() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> NumberList.isIncreasing(Arrays.asList(1)));
        assertEquals("Legalább két elemű lista kell!", ex.getMessage());
    }

    @Test
    public void testNumsNull() {
        Exception ex = assertThrows(NullPointerException.class, () -> NumberList.isIncreasing(null));
        assertEquals("A lista nem lehet null vagy üres!", ex.getMessage());
    }

    @Test
    public void testNumsEmpty() {
        Exception ex = assertThrows(NullPointerException.class, () -> NumberList.isIncreasing(Arrays.asList()));
        assertEquals("A lista nem lehet null vagy üres!", ex.getMessage());
    }

}