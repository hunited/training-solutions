package sorting;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class OrderedLibrary {

    private Set<Book> library = new TreeSet<>();

    public OrderedLibrary(Set<Book> library) {
        this.library = library;
    }

    public Book lendFirstBook() {
        Iterator<Book> iterator = library.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        throw new NullPointerException("Libray is empty!");
    }

}
