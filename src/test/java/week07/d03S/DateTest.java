package week07.d03S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    private final Date date = Date.of(2021, 3, 8);

    @Test
    void of() {
        assertEquals(2021, date.getYear());
        assertEquals(3, date.getMonth());
        assertEquals(8, date.getDay());
    }

    @Test
    void ofError() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2000,0,8));
        assertThrows(IllegalArgumentException.class, () -> new Date(2000,3,32));
        assertThrows(IllegalArgumentException.class, () -> new Date(1899,3,8));
    }

    @Test
    void withYear() {
        assertEquals(1980, date.withYear(1980).getYear());
    }

    @Test
    void withMonth() {
        assertEquals(12, date.withMonth(12).getMonth());
    }

    @Test
    void withDay() {
        assertEquals(29, date.withDay(29).getDay());
    }

}
