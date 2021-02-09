package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionManager {

    private final List<Book> library;

    public CollectionManager(List<Book> library) {
        this.library = library;
    }

    public List<Book> createUnmodifiableLibrary() {
        return Collections.unmodifiableList(library);
    }

    public List<Book> reverseLibrary() {
        List<Book> result = new ArrayList<>(library);
        Collections.sort(result);
        Collections.reverse(result);
        return result;
    }

    public Book getFirstBook() {
        return Collections.min(library);
    }

    public Book getLastBook() {
        return Collections.max(library);
    }

}
