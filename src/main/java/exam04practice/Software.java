package exam04practice;

public abstract class Software {

    protected String name;
    protected int price;

    protected Software(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    abstract void increasePrice();

}
