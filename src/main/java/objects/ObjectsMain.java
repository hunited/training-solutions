package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {

    public static void main(String[] args) {

        Book booknull = null;

        System.out.println(booknull);

        Book emptyBook;

        //System.out.println(emptyBook);

        emptyBook = null;

        System.out.println(emptyBook);

        if (emptyBook == null) {
            System.out.println("Az emptyBook értéke null");
        } else {
            System.out.println("Az emptyBook értéke: " + emptyBook);
        }

        Book book = new Book();

        System.out.println(book);

        book = null;

        System.out.println(book);

        book = new Book();

        System.out.println(book);

        Book anotherBook = new Book();

        if (book == anotherBook) {
            System.out.println("A két érték azonos.");
        } else {
            System.out.println("A két érték eltérő.");
        }

        anotherBook = book;

        if (book == anotherBook) {
            System.out.println("A két érték azonos.");
        } else {
            System.out.println("A két érték eltérő.");
        }

        System.out.println(anotherBook instanceof Book);

        Book[] books = {new Book(), new Book(), new Book()};

        List<Book> books1 = Arrays.asList(new Book(), new Book(), new Book());

        List<Book> books2 = new ArrayList<>();
        books2.add(new Book());
        books2.add(new Book());
        books2.add(new Book());

    }

}
