package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathAlgorithmsTest {

    @Test
    public void tesztPrim2() {
        assertTrue(MathAlgorithms.isPrime(2));
    }

    @Test
    public void tesztPrim1() {
        assertFalse(MathAlgorithms.isPrime(1));
    }

    @Test
    public void tesztPrim199() {
        assertTrue(MathAlgorithms.isPrime(199));
    }

    @Test
    public void tesztPrim200() {
        assertFalse(MathAlgorithms.isPrime(200));
    }

    @Test
    public void tesztPrimNeg() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new MathAlgorithms().isPrime(-1));
        assertEquals("A szám nem lehet negatív!", ex.getMessage());
    }

}
