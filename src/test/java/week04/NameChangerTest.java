package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameChangerTest {

    @Test
    void testName() {

        assertEquals("John Doe", new NameChanger("John Doe").getFullName());

    }

    @Test
    void testNameEmpty() {
        NameChanger nameChanger = new NameChanger("John Doe");
        assertEquals("John Doe", nameChanger.getFullName());

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
        assertEquals("Invalid name: ", iae.getMessage());
    }

    @Test
    void testNameChanger() {

        assertEquals("Jane Doe", new NameChanger("John Doe").changeFirstName("Jane"));

    }

}
