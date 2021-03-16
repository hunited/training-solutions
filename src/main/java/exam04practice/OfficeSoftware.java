package exam04practice;

public class OfficeSoftware extends Software {

    protected OfficeSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    void increasePrice() {
        price = (int) (price * 1.05);
    }

}
