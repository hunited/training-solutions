package lambdastreams.baseoperations;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void min() {
        Numbers numbers = new Numbers(Arrays.asList(1, 4, 7, 2, -3, 9, -4));
        assertEquals(Optional.of(-4), numbers.min());
    }

    @Test
    void minForEmptyList() {
        Numbers numbers = new Numbers(Collections.emptyList());
        assertEquals(Optional.empty(), numbers.min());
    }

    @Test
    void sum() {
        Numbers numbers = new Numbers(Arrays.asList(1, 4, 7, 2, -3, 9, -4));
        assertEquals(16, numbers.sum());
    }

    @Test
    void sumForEmptyList() {
        Numbers numbers = new Numbers(Collections.emptyList());
        assertEquals(0, numbers.sum());
    }

    @Test
    void getDistinctElements() {
        Numbers numbers = new Numbers(Arrays.asList(1, 2, 1, 2, 1, 2, 4, 4, 4, 6));
        assertEquals(4, numbers.getDistinctElements().size());
    }

    @Test
    void isAllPositive() {
        Numbers numbers = new Numbers(Arrays.asList(1, 2, 1, 2, 1, 2, 4, 4, 4, 6));
        assertTrue(numbers.isAllPositive());
    }

    @Test
    void isNotAllPositive() {
        Numbers numbers = new Numbers(Arrays.asList(1, 4, 7, 2, -3, 9, -4));
        assertFalse(numbers.isAllPositive());
    }

}
