package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LibraryTest {

    @Test
    void shouldThrowExceptionIfArgumentIsNull() {
        assertThrows(NullPointerException.class, () -> new Library().getFirstBook(null));
    }

    @Test
    void shouldThrowExceptionIfArgumentIsEmptyList() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Library().getFirstBook(new ArrayList()));
        assertEquals("Argument should not be empty!", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionAddingDifferentObjects() {
        Library library = new Library();
        Exception ex = assertThrows(ClassCastException.class, () -> library.getFirstBook(Arrays.asList("", "", "")));
        assertEquals("Not a book", ex.getMessage());
    }

    @Test
    void shouldReturnFirst() {
        assertEquals("Egri Csillagok", new Library().getFirstBook(Arrays.asList(new Book("Egri Csillagok"), new Book("Antigoné"))).getTitle());
    }

}
