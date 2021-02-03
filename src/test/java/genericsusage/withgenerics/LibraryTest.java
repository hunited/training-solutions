package genericsusage.withgenerics;

import org.junit.jupiter.api.Test;

import genericsusage.Book;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LibraryTest {

    @Test
    void shouldThrowExceptionIfArgumentIsNull() {
        assertThrows(NullPointerException.class, () -> new Library().getFirstBook(null));
    }

    @Test
    void shouldThrowExceptionIfArgumentIsEmptyList() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Library().getFirstBook(Collections.emptyList()));
        assertEquals("Argument should not be empty!", ex.getMessage());
    }

    @Test
    void shouldReturnFirst() {
        assertEquals("Egri Csillagok", new Library().getFirstBook(Arrays.asList(new Book("Egri Csillagok"))).getTitle());
    }

}
