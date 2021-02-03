package collectionsequalshash;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        Book temp = new Book(title, author);
        if (!books.contains(temp)) {
            return null;
        }
        return books.get(books.indexOf(temp));
    }

    public Book findBook(List<Book> books, Book book) {
        if (!books.contains(book)) {
            return null;
        }
        return books.get(books.indexOf(book));
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> booksSet = new HashSet<>();
        Collections.addAll(booksSet, books);
        return booksSet;
    }

}
