package lambdastreams.bookstore;

public class Book {

    private final String title;
    private final int yearOfPublish;
    private final int price;
    private final int piece;

    public Book(String title, int yearOfPublish, int price, int piece) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
        this.piece = piece;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public int getPiece() {
        return piece;
    }

}
