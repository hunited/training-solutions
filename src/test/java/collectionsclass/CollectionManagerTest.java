package collectionsclass;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionManagerTest {

    private final List<Book> bookList = new ArrayList<>();

    @BeforeEach
    public void setUp() throws IOException {
        InputStream is = CollectionManagerTest.class.getResourceAsStream("books.csv");
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(";");
                bookList.add(new Book(Integer.parseInt(lineParts[0]), lineParts[1], lineParts[2]));
            }
        }
    }

    @Test
    void unmodifiableListShouldThrowExceptionOnAdd() throws UnsupportedOperationException {
        CollectionManager cm = new CollectionManager(bookList);
        assertThrows(UnsupportedOperationException.class, () -> {
            cm.createUnmodifiableLibrary().add(new Book(5555, "Douglas Adams", "Hitchhikers Guide"));
        });
    }

    @Test
    void testReverseLibrary() {
        CollectionManager cm = new CollectionManager(bookList);
        List<Book> bookList = cm.reverseLibrary();
        assertEquals(1172, bookList.get(0).getId());
        assertEquals(1001, bookList.get(bookList.size() - 1).getId());
    }

    @Test
    void testGetFirstBook() {
        CollectionManager cm = new CollectionManager(bookList);
        Book book = cm.getFirstBook();
        assertEquals(1001, book.getId());
    }

    @Test
    void testGetLastBook() {
        CollectionManager cm = new CollectionManager(bookList);
        Book book = cm.getLastBook();
        assertEquals(1172, book.getId());
        assertEquals("Az elfeledett mackó", book.getTitle());
        assertEquals("Anna Mangan", book.getAuthor());
        assertEquals("1172 Anna Mangan Az elfeledett mackó", book.toString());
    }

    @Test
    void equalsAndHashCodeTest() {
        Book book1 = new Book(1172, "Anna Morgan", "Az elfeledett mackó");
        Book book2 = new Book(1172, "A. Morgan", "");
        assertTrue(book1.equals(book2));
        assertEquals(1172, book1.hashCode());
    }

}
