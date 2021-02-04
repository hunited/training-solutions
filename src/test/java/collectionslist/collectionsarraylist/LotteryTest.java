package collectionslist.collectionsarraylist;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    void wrongParametersShouldThrowExeption() throws IllegalArgumentException {
        int lotteryType = 6;
        int ballCount = 6;
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Lottery().selectWinningNumbers(lotteryType, ballCount);
        });
        assertEquals("Balls must be more then the winning numbers!", ex.getMessage());
    }

    @Test
    void winningNumbersCountShouldBeEqualToLotteryType() throws IllegalArgumentException {
        int lotteryType = 5;
        int ballCount = 90;
        List<Integer> winningNumbers = new Lottery().selectWinningNumbers(lotteryType, ballCount);
        assertEquals(lotteryType, new HashSet<>(winningNumbers).size());
        for (int winningNumber : winningNumbers) {
            assertTrue(winningNumber > 0);
            assertTrue(winningNumber <= ballCount);
        }
    }

}
