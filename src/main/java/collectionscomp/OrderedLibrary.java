package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {

    List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle() {
        List<Book> orderedBooks = new ArrayList<>(libraryBooks);
        Collections.sort(orderedBooks);
        return orderedBooks;
    }

    public List<Book> orderedByAuthor() {
        List<Book> orderedBooks = new ArrayList<>(libraryBooks);
        orderedBooks.sort(new AuthorComparator());
        return orderedBooks;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> orderedBooks = new ArrayList<>();
        for (Book book : libraryBooks) {
            orderedBooks.add(book.getTitle());
        }
        Collator lang = Collator.getInstance(locale);
        orderedBooks.sort(lang);
        return orderedBooks;
    }

}
