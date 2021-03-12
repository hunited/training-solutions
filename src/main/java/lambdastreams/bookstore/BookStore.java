package lambdastreams.bookstore;

import java.util.*;
import java.util.stream.Collectors;

public class BookStore {

    private final List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public int getNumberOfBooks() {
        return getBooks().stream().reduce(0, (a, b) -> a + b.getPiece(), Integer::sum);
    }

    public Optional<Book> findNewestBook() {
        return getBooks().stream().max(Comparator.comparingInt(Book::getYearOfPublish));
    }

    public int getTotalValue() {
        return getBooks().stream().reduce(0, (a, b) -> a + b.getPrice() * b.getPiece(), Integer::sum);
    }

    public List<Book> getByYearOfPublish(int year) {
        return getBooks().stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

}
