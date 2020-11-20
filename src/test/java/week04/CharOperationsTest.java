package week04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharOperationsTest {

    @Test
    public void charTest() {
        CharOperations ca = new CharOperations();
        List<Integer> test = List.of(0, 3);
        assertEquals(test, ca.getPositionOfChar("Alma", "a"));
    }

}
