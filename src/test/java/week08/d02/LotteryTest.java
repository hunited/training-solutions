package week08.d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    public void testGenerator() {
        List<Integer> winners = new Lottery().winnersGenerator(90, 5,10);
        assertEquals(1, winners.get(0));
        assertEquals(34, winners.get(1));
        assertEquals(61, winners.get(2));
        assertEquals(64, winners.get(3));
        assertEquals(77, winners.get(4));
    }

    @Test
    public void testGeneratorList() {
        List<Integer> winners = new Lottery().winnersGenerator(90, 5,10);
        List<Integer> test = new ArrayList<>(Arrays.asList(1, 34, 61, 64, 77));
        assertEquals(test, winners);
    }

}
