package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {

    List<String> books = new ArrayList<>();

    public void add(String title) {
        books.add(title);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> found = new ArrayList<>();
        for (String title : books) {
            if (title.toLowerCase().startsWith(prefix.toLowerCase())) {
                found.add(title);
            }
        }
        return found;
    }

    public List<String> getBooks() {
        return books;
    }

    public void removeByPrefix(String prefix) {
        List<String> toDelete = new ArrayList<>();
        for (String title : books) {
            if (title.toLowerCase().startsWith(prefix.toLowerCase())) {
                toDelete.add(title);
            }
        }
        books.removeAll(toDelete);
    }

    public static void main(String[] args) {

        Books books = new Books();

        books.add("Java alapok");
        books.add("Java haladó");
        books.add("Phyton alapok");
        books.add("Phyton haladó");
        books.add("phyton haladó");

        System.out.println(books.getBooks());

        System.out.println(books.findAllByPrefix("Java"));
        System.out.println(books.getBooks());

        System.out.println(books.findAllByPrefix("PhYton"));
        System.out.println(books.getBooks());

        books.removeByPrefix("Phyton");

        System.out.println(books.getBooks());
    }

}
