package week08.d01S;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SultanTest {

    @Test
    void openedDoors() {
        List<Integer> openList = Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81, 100);
        assertEquals(openList, new Sultan().openedDoors());
    }

}
