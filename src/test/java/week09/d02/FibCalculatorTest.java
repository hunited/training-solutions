package week09.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibCalculatorTest {

    @Test
    public void testCalculator() {
        assertEquals(60696, new FibCalculator().sumEvens(100000));
        assertEquals(3382, new FibCalculator().sumEvens(10000));
        assertEquals(798, new FibCalculator().sumEvens(1000));
        assertEquals(44, new FibCalculator().sumEvens(100));
    }

    @Test
    public void testCalculatorFail() {
        Exception ex = assertThrows(IllegalArgumentException.class, ()-> new FibCalculator().sumEvens(0));
        assertEquals("A bemeneti érték nem lehet kettőnél kisebb!", ex.getMessage());
    }

}