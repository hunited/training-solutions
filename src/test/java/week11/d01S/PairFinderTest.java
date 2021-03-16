package week11.d01S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void findPairs() {
        assertEquals(4, new PairFinder().findPairs(new int[]{7, 1, 5, 7, 3, 3, 5, 7, 6, 7}));
        assertEquals(3, new PairFinder().findPairs(new int[]{7, 1, 5, 7, 3, 3, 5, 7, 6}));
        assertEquals(4, new PairFinder().findPairs(new int[]{7, 1, 5, 7, 3, 3, 5, 7, 7}));
        assertEquals(1, new PairFinder().findPairs(new int[]{5, 1, 4, 5}));
    }

}
