package week03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    void testParse() {

        assertEquals(80, new Operation("68+12").getResult());

    }

    @Test
    void testParseSpaces() {

        assertEquals(80, new Operation("   68 + 12 ").getResult());

    }

    @Test
    void testParseNoPlus() {

        assertEquals(0, new Operation("6812").getResult());

    }

}
