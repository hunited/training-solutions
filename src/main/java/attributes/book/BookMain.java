package attributes.book;

public class BookMain {

    public static void main(String[] args) {

        Book book = new Book("Kőszívű ember fiai");

        System.out.println(book.getTitle());

        book.setTitle("Egy másik cím");

        System.out.println(book.getTitle());

    }

}
