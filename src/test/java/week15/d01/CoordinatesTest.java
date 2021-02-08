package week15.d01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    Coordinates coordinates = new Coordinates();
    Map<Double, Double> test = new HashMap<>();

    @BeforeEach
    void setUp() {
        test.put(1.0, 5.0);
        test.put(2.0, 7.0);
        test.put(5.0, 3.0);
        test.put(3.0, 9.0);
        test.put(-3.0, 8.0);
    }

    @Test
    void testmaxFinder() {
        Map.Entry<Double, Double> result = coordinates.maxFinder(test);
        assertEquals(3, result.getKey());
        assertEquals(9, result.getValue());
    }

    @Test
    void testmaxFinderErrorNull() {
        assertThrows(IllegalArgumentException.class, () -> coordinates.maxFinder(new HashMap<>()));
    }

    @Test
    void testmaxFinderErrorMin() {
        assertThrows(IllegalArgumentException.class, () -> coordinates.maxFinder(new HashMap<>(Map.of(0.0, Double.MIN_VALUE))));
    }

}
