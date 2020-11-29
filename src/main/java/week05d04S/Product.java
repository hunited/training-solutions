package week05d04S;

import java.util.EnumMap;

public class Product {

    private long price;

    public enum CURRENCY {
        HUF,
        USD
    }

    public long getPrice() {
        return price;
    }

    public Product(long price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Az érték 0 felett kell hogy legyen!");
        }
        this.price = price;
    }

    public double convertPrice(CURRENCY currency) {
        if (currency != CURRENCY.HUF && currency != CURRENCY.USD) {
            throw new IllegalArgumentException("Nem megfelelő pénznem.");
        }
        double RATE = 300.0;
        double value = 0.0;
        if (currency == CURRENCY.HUF) {
            value = getPrice() / RATE;
        } else if (currency == CURRENCY.USD) {
            value = getPrice() * RATE;
        }
        return value;
    }

    public static void main(String[] args) {
        Product p = new Product(150);
        System.out.println(p.convertPrice(CURRENCY.USD));
    }

}
