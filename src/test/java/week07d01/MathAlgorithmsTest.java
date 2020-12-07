package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathAlgorithmsTest {

    @Test
    public void tesztPrim2() {
        MathAlgorithms a = new MathAlgorithms();
        assertEquals(true, a.isPrime(2));
    }

    @Test
    public void tesztPrim1() {
        MathAlgorithms a = new MathAlgorithms();
        assertEquals(false, a.isPrime(1));
    }

    @Test
    public void tesztPrim199() {
        MathAlgorithms a = new MathAlgorithms();
        assertEquals(true, a.isPrime(199));
    }

    @Test
    public void tesztPrim200() {
        MathAlgorithms a = new MathAlgorithms();
        assertEquals(false, a.isPrime(200));
    }

    @Test
    public void tesztPrimNeg() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new MathAlgorithms().isPrime(-1));
        assertEquals("A szám nem lehet negatív!", ex.getMessage());
    }

}
