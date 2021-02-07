package searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookArraySearchTest {

    private final List<Book> bookList = new ArrayList<>();

    @BeforeEach
    public void setUp() throws IOException {
        InputStream is = BookArraySearchTest.class.getResourceAsStream("books.csv");
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(";");
                bookList.add(new Book(Integer.parseInt(lineParts[0]), lineParts[1], lineParts[2]));
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("File not found");
        }
    }

    @Test
    void emptyParametersShouldThrowException() throws IllegalArgumentException {
        Book[] bookArray = new Book[bookList.size()];
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new BookArraySearch(bookList.toArray(bookArray)).findBookByAuthorTitle("", ""));
        assertEquals("Author or title must not be empty!", ex.getMessage());
    }

    @Test
    void emptyParametersShouldThrowExceptionNull() throws IllegalArgumentException {
        Book[] bookArray = new Book[bookList.size()];
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new BookArraySearch(bookList.toArray(bookArray)).findBookByAuthorTitle(null, null);
        });
        assertEquals("Author or title must not be empty!", ex.getMessage());
    }

    @Test
    void notFoundBookShouldThrowException() throws IllegalArgumentException {
        String author = "Homérosz";
        String title = "Iliász";
        Book[] bookArray = new Book[bookList.size()];
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new BookArraySearch(bookList.toArray(bookArray)).findBookByAuthorTitle(author, title);
        });
        assertEquals("No book found by " + author + " with title " + title, ex.getMessage());
    }

    @Test
    void testFindBookByAuthorTitle() {
        Book[] bookArray = new Book[bookList.size()];
        BookArraySearch bas = new BookArraySearch(bookList.toArray(bookArray));
        Book book = bas.findBookByAuthorTitle("Fazekas Anna", "Mackó, mókus, malacka");
        assertEquals(1010, book.getId());
        assertEquals("Fazekas Anna", book.getAuthor());
        assertEquals("Mackó, mókus, malacka", book.getTitle());
        assertEquals("1010 Fazekas Anna Mackó, mókus, malacka", book.toString());
    }

}
