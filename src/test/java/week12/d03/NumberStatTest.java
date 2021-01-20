package week12.d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {

    @Test
    void testNumberStat() {
        NumberStat ns = new NumberStat();
        assertEquals(3, ns.numberFinder(List.of(1, 1, 5, 3, 4, 5, 6, 5, 6, 4, 1, 6, 5, 4)));
        assertEquals(1, ns.numberFinder(List.of(1)));
    }

    @Test
    void testNumberStatError() {
        NumberStat ns = new NumberStat();
        assertThrows(IllegalArgumentException.class, () -> ns.numberFinder(List.of()));
        assertThrows(IllegalArgumentException.class, () -> ns.numberFinder(null));
    }

}