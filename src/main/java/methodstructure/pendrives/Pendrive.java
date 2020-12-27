package methodstructure.pendrives;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public void risePrice(int percent) {
        price += price * (percent / 100.0);
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        double thisPricePerGb = 1.0 * this.price / this.capacity;
        double otherPricePerGb = 1.0 * pendrive.price / pendrive.capacity;
        if (thisPricePerGb > otherPricePerGb) {
            return 1;
        } else if (thisPricePerGb < otherPricePerGb) {
            return -1;
        }
        return 0;
    }

    public boolean cheaperThan(Pendrive pendrive) {
        return this.price < pendrive.price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

}
