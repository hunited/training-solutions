package week13.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LettersTest {

    Letters l = new Letters();

    @Test
    void letterCounterTest() {
        assertEquals(8, l.letterCounter("Árvíztűrő tükörfúrógép 12")); //8 rvztkfgp
    }

    @Test
    void letterCounterError() {
        assertThrows(IllegalArgumentException.class, () -> l.letterCounter(""));
        assertThrows(IllegalArgumentException.class, () -> l.letterCounter(null));
    }

}
