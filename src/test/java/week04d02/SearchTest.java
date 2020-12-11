package week04d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {

    @Test
    public void charTest() {
        Search ca = new Search();
        List<Integer> test = List.of(0, 3, 5);
        assertEquals(test, ca.getPositionOfChar("Almafa", "a"));
    }

}
