package searching;

public class Book implements Comparable<Book> {

    private final int id;
    private final String author;
    private final String title;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }

    @Override
    public int compareTo(Book otherBook) {
        if (author.compareTo(otherBook.author) != 0) {
            return author.compareTo(otherBook.author);
        } else {
            return this.title.compareTo(otherBook.title);
        }
    }

}
