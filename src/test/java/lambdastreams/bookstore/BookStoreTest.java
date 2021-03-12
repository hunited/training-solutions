package lambdastreams.bookstore;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BookStoreTest {

    List<Book> books;

    @BeforeEach
    public void initializeList() {
        books = new ArrayList<>();
        books.add(new Book("Learn Java in 24 hours", 2014, 3800, 22));
        books.add(new Book("Spring in Action", 2017, 5700, 10));
        books.add(new Book("Effective Java", 2017, 4500, 16));
        books.add(new Book("Java in a Nutshell", 2009, 9500, 31));
        books.add(new Book("Java Cookbook", 2014, 9200, 4));
    }

    @AfterEach
    public void destroyList() {
        books = null;
    }

    @Test
    void getNumberOfBooks() {
        BookStore bookStore = new BookStore(books);
        assertEquals(83, bookStore.getNumberOfBooks());
    }

    @Test
    void getNumberOfBooksForEmptyList() {
        BookStore bookStore = new BookStore(Collections.emptyList());
        assertEquals(0, bookStore.getNumberOfBooks());
    }

    @Test
    void findNewestBook() {
        BookStore bookStore = new BookStore(books);
        assertEquals(2017, bookStore.findNewestBook().get().getYearOfPublish());
    }

    @Test
    void findNewestBookForEmptyList() {
        BookStore bookStore = new BookStore(Collections.emptyList());
        assertEquals(Optional.empty(), bookStore.findNewestBook());
    }

    @Test
    void getTotalValue() {
        BookStore bookStore = new BookStore(books);
        assertEquals(543_900, bookStore.getTotalValue());
    }

    @Test
    void getTotalValueForEmptyList() {
        BookStore bookStore = new BookStore(Collections.emptyList());
        assertEquals(0, bookStore.getTotalValue());
    }

    @Test
    void getByYearOfPublish() {
        BookStore bookStore = new BookStore(books);
        assertEquals(2, bookStore.getByYearOfPublish(2017).size());
        assertEquals(5700, bookStore.getByYearOfPublish(2017).get(0).getPrice());
    }

    @Test
    void getByYearOfPublishMissingYear() {
        BookStore bookStore = new BookStore(books);
        assertEquals(null, bookStore.getByYearOfPublish(2007));
    }

    @Test
    void getByYearOfPublishForEmptyList() {
        BookStore bookStore = new BookStore(Collections.emptyList());
        assertEquals(null, bookStore.getByYearOfPublish(2007));
    }

}
