package week02d02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {

    List<Product> products = new ArrayList<>();

    public Store(List<Product> products) {
        this.products = products;
    }

    public String getProductsByCategory(List<Product> products) {
        String result = "";
        for (Category c : Category.values()) {
            int i = 0;
            for (Product p : products) {
                if (p.getCategory().toString().equals(c.toString())) {
                    i++;
                }
            }
            c.setPiece(i);
            result = result.concat(c.toString() + ": " + i + " db.\n");
        }
        return result;
    }

    public static void main(String[] args) {
        Product product1 = new Product("Kenyér", Category.DAIRY, 220);
        Product product2 = new Product("Tej", Category.DAIRY, 280);
        Product product3 = new Product("Zsemle", Category.DAIRY, 30);
        Product product4 = new Product("Mexikói zöldségkeverék", Category.FROZEN, 649);
        List<Product> products = Arrays.asList(product1, product2, product3, product4);
        Store store = new Store(products);
        System.out.println(store.getProductsByCategory(products));
    }

}
