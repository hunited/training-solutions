package week06.d04S;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> list = new ArrayList<>();

    public List<Product> getList() {
        return list;
    }

    public List<Product> addItem(String name, int quantity) {
        Product temp = contain(name);
        if (temp == null) {
            list.add(new Product(name, quantity));
        } else {
            temp.addQuantity(quantity);
        }
        return list;
    }

    public int getItem(String name) {
        int q = 0;
        if (contain(name) != null) {
            q = contain(name).getQuantity();
        }
        return q;
    }

    private Product contain(String name) {
        Product found = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                found = list.get(i);
            }
        }
        return found;
    }

}
