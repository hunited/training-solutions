package classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Gárdonyi Géza","Egri csillagok");
        book.register("9789634153092");

        System.out.println("Szerző: "+book.getAuthor()+"\nCím: "+book.getTitle()+"\nISBN: "+book.getRegNumber());
    }
}
