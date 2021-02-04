package collectionslist.collectionslinkedlist;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DrawTest {

    @Test
    void wrongParametersShouldThrowExeption() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Draw().drawNumbers(8, 8);
        });
        assertEquals("drawCount must be less then 8!", ex.getMessage());
    }

    @Test
    void drawnNumbersCountShouldBeEqualToDrawCount() throws IllegalArgumentException {
        int drawCount = 5;
        int maxNumber = 90;
        Set<Integer> drawnNumbers = new Draw().drawNumbers(drawCount, maxNumber);
        for (int drawnNumber : drawnNumbers) {
            assertTrue(drawnNumber > 0);
            assertTrue(drawnNumber <= maxNumber);
        }
    }

}
