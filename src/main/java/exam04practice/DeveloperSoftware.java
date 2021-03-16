package exam04practice;

public class DeveloperSoftware extends Software {

    protected DeveloperSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    void increasePrice() {
        price = (int) (price * 1.1);
    }

}
