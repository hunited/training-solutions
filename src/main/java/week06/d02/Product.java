package week06.d02;

public class Product {

    private String name;

    private Category category;

    private int price;

    public Product(String name, Category category, int price) {
        if (name == null || "".equals(name)) {
            throw new NullPointerException("A termék neve nem lehet Null!");
        }
        this.name = name;
        if (category == null) {
            throw new NullPointerException("A termék kategóriája nem lehet Null!");
        }
        this.category = category;
        if (price < 1) {
            throw new IllegalArgumentException("A termék ára nem lehet nulla vagy kisebb!");
        }
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + category + "), " + price;
    }
}
