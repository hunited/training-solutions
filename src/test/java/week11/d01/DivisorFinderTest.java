package week11.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    void testDivisorFinder() {
        assertEquals(1, new DivisorFinder().findDivisors(425));
        assertEquals(1, new DivisorFinder().findDivisors(417));
        assertEquals(2, new DivisorFinder().findDivisors(123));
        assertEquals(1, new DivisorFinder().findDivisors(-425));
        assertEquals(1, new DivisorFinder().findDivisors(-417));
        assertEquals(2, new DivisorFinder().findDivisors(-123));
        assertEquals(2, new DivisorFinder().findDivisors(-120));
    }

}
