package week10.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testCalculator() {

        assertEquals(16, new Calculator().findMinSum(new int[]{1, 3, 5, 7, 9}));
        assertEquals(16, new Calculator().findMinSum(new int[]{1, 9, 5, 7, 3}));
        assertEquals(11, new Calculator().findMinSum(new int[]{1, 9, 7, 5, 3, 2}));

    }

    @Test
    void testCalculatorToSmallList() {

        Exception ex1 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Calculator().findMinSum(new int[]{1, 9, 7}));
        assertEquals("Túl kicsi a lista", ex1.getMessage());

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Calculator().findMinSum(new int[]{}));

    }

}
