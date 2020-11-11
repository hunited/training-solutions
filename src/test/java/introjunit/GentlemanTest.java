package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTest {

    @Test
    void testCreate() {
        assertEquals("Hello John Doe", new Gentleman().sayHello("John Doe"));
    }

    @Test
    void testCreateError() {
        assertEquals("Hello Jhn Doe", new Gentleman().sayHello("John Doe"));
    }

    @Test
    void testCreateNull() {

        // Given
        Gentleman gentleman = new Gentleman();

        // When
        String name = gentleman.sayHello(null);

        // Then
        assertEquals("Hello Anonymous", name);

    }

}
