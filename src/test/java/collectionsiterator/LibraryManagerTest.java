package collectionsiterator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LibraryManagerTest {

    private LibraryManager manager;

    @BeforeEach
    public void setup() {
        Set<Book> bookSet = new HashSet<>(Arrays.asList(new Book(1245, "Core Java", "Cay Horstmann"),
                new Book(2454, "Core JavaServer Faces", "Cay Horstmann"),
                new Book(5454, "Effective Java", "Bloch")));
        manager = new LibraryManager(bookSet);
    }

    @Test
    void missingRegnumberShouldThrowException() throws MissingBookException {
        Exception ex = assertThrows(MissingBookException.class, () -> {
            manager.findBookByRegNumber(1212);
        });
        assertEquals("No books found with regnumber: " + 1212, ex.getMessage());
    }

    @Test
    void testFindBookByRegNumber() {
        Book book = manager.findBookByRegNumber(1245);
        assertEquals("Cay Horstmann", book.getAuthor());
        assertEquals("Core Java", book.getTitle());
    }

    @Test
    void missingRegnumberShouldThrowExceptionAtRemove() throws MissingBookException {
        Exception ex = assertThrows(MissingBookException.class, () -> {
            manager.removeBookByRegNumber(1212);
        });
        assertEquals("No books found with regnumber: " + 1212, ex.getMessage());
    }

    @Test
    void testRemoveBookByRegNumber() {
        int removedBookId = manager.removeBookByRegNumber(2454);
        assertEquals(2454, removedBookId);
        assertEquals(2, manager.libraryBooksCount());
    }

    @Test
    void nonExistingAuthorShouldThrowExceptionAtRemove() throws MissingBookException {
        Exception ex = assertThrows(MissingBookException.class, () -> {
            manager.selectBooksByAuthor("Tolkien");
        });
        assertEquals("No books found by Tolkien", ex.getMessage());
    }

    @Test
    void testSelectBooksByAuthor() {
        Set<Book> foundBooks = manager.selectBooksByAuthor("Cay Horstmann");
        assertEquals(2, foundBooks.size());
    }

}
