package sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderedArrayLibraryTest {

    private final List<Book> bookList = new ArrayList<>();

    @BeforeEach
    public void setUp() throws IOException {
        InputStream is = OrderedArrayLibraryTest.class.getResourceAsStream("books.csv");
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
    void testSortingById() {
        Collections.shuffle(bookList);
        Book[] bookArray = new Book[bookList.size()];
        OrderedArrayLibrary orderedLibrary = new OrderedArrayLibrary(bookList.toArray(bookArray));
        Book[] books = orderedLibrary.sortingById();
        assertEquals(1001, books[0].getId());
        assertEquals(1172, books[books.length - 1].getId());
    }

    @Test
    void testSortingByTitle() {
        Collections.shuffle(bookList);
        Book[] bookArray = new Book[bookList.size()];
        OrderedArrayLibrary orderedLibrary = new OrderedArrayLibrary(bookList.toArray(bookArray));
        Book[] books = orderedLibrary.sortingByTitle();
        assertEquals("A babó", books[0].getTitle());
        assertEquals("Tolkien", books[0].getAuthor());
        assertEquals("1082 Tolkien A babó", books[0].toString());
        assertEquals("Öreg néne őzikéje", books[books.length - 1].getTitle());
    }

    @Test
    void equalAndHashCodeTest() {
        Book book = new Book(1082, "J.R.R Tolkien", "The Hobbit");
        Book[] bookArray = new Book[bookList.size()];
        OrderedArrayLibrary orderedLibrary = new OrderedArrayLibrary(bookList.toArray(bookArray));
        Book[] books = orderedLibrary.sortingByTitle();
        assertEquals(book, books[0]);
        assertEquals(1082, book.hashCode());
    }

}
