package week03.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneParserTest {

    @Test
    void testParse() {

        // Given
        PhoneParser parser = new PhoneParser();
        String s = "80-6666666";

        // When
        Phone phone = parser.parse(s);

        // Then
        assertEquals("80-6666666", phone.toString());

    }

}
