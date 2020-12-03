package week06d04;

import java.time.LocalDate;

public class Item {

    private int price;
    private LocalDate date;
    private String name;


    public Item(int price, LocalDate date, String name) {
        if (price < 1){
            throw new IllegalArgumentException("Az ár nem lehet nulla vagy kisebb!");
        }
        this.price = price;
        this.date = date;
        if (name == null || "".equals(name)){
            throw new NullPointerException("A név nem lehet üres!");
        }
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + price + " Ft), ekkor: " + date + ".";
    }
}
