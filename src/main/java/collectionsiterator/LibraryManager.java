package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private final Set<Book> bookSet;

    public LibraryManager(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public Book findBookByRegNumber(int regNumber) {
        Iterator<Book> book = bookSet.iterator();
        while (book.hasNext()) {
            Book founded = book.next();
            if (founded.getRegNumber() == regNumber) {
                return founded;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> result = new HashSet<>();
        Iterator<Book> book = bookSet.iterator();
        while (book.hasNext()) {
            Book founded = book.next();
            if (founded.getAuthor().equals(author)) {
                result.add(founded);
            }
        }
        if (!result.isEmpty()) {
            return result;
        } else {
            throw new MissingBookException("No books found by " + author);
        }
    }

    public int removeBookByRegNumber(int regNumber) {
        bookSet.remove(findBookByRegNumber(regNumber));
        return regNumber;
    }

    public int libraryBooksCount() {
        return bookSet.size();
    }

}
