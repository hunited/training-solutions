package collectionsequalshash;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookCatalogTest {

    private static final Book[] books = new Book[]{
            new Book("1212", "Egri Csillagok", "Gárdonyi Géza"),
            new Book("2121", "Vuk", "Fekete István"),
            new Book("4545", "Rab Ráby", "Jókai Mór")
    };

    @Test
    void findSelectedBookInBookList() {
        Book foundBook = new BookCatalog().findBookByTitleAuthor(Arrays.asList(books), "Vuk", "Fekete István");
        assertEquals("2121", foundBook.getRegNumber());
        assertEquals("Fekete István", foundBook.getAuthor());
        assertEquals("Vuk", foundBook.getTitle());
        assertEquals("Book{regNumber='2121', title='Vuk', author='Fekete István'}", foundBook.toString());
    }

    @Test
    void bookIsNotInBookList() {
        Book foundBook = new BookCatalog().findBookByTitleAuthor(Arrays.asList(books), "Vuk", "");
        assertEquals(null, foundBook);
    }

    @Test
    void findSelectedBookInSearchableBookList() {
        Book searchingFor = new Book("2121", "Vuk", "Fekete István");
        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);
        assertTrue(searchingFor.equals(foundBook));
    }

    @Test
    void selectedBookIsNotInBookList() {
        Book searchingFor = new Book("2121", "Vuk", "István");
        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);
        assertEquals(null, foundBook);
    }

    @Test
    void findBookByTitleAndAuthor() {
        Book searchingFor = new Book("Vuk", "Fekete István");
        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);
        assertTrue(searchingFor.equals(foundBook));
    }

    @Test
    void addSameBooksToSet() {
        Book[] sameBooks = new Book[]{
                new Book("1212", "Egri Csillagok", "Gárdonyi Géza"),
                new Book("1212", "Egri Csillagok", "Gárdonyi Géza"),
                new Book("1212", "Egri Csillagok", "Gárdonyi Géza")
        };
        Set<Book> bookSet = new BookCatalog().addBooksToSet(sameBooks);
        assertEquals(1, bookSet.size());
    }

}
