package collectionsequalshash;

import java.util.Objects;

public class Book {

    private String regNumber;
    private final String title;
    private final String author;

    public Book(String regNumber, String title, String author) {
        this(title, author);
        this.regNumber = regNumber;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "regNumber='" + regNumber + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}
