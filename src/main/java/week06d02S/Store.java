package week06d02S;

import java.util.ArrayList;
import java.util.List;

public class Store {

    List<Product> products = new ArrayList<>();

    public Store(List<Product> products) {
        this.products = products;
    }

    public String getProductsByCategory(List<Product> products) {
        if (products == null || products.size()==0) {
            throw new NullPointerException("A terméklista nem lehet üres!");
        }
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

}
