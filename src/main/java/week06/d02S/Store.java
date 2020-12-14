package week06.d02S;

import java.util.List;

public class Store {

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
