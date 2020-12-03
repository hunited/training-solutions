package week06d04S;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> list = new ArrayList<>();

    public List<Product> getList() {
        return list;
    }

    public List<Product> addItem(String name, int quantity) {
        int temp = contain(name);
        if (temp != -1) {
            list.get(temp).addQuantity(quantity);
        } else {
            list.add(new Product(name, quantity));
        }
        return list;
    }

    public int getItem(String name) {
        int q = 0;
        if (contain(name) > -1) {
            q = list.get(contain(name)).getQuantity();
        }
        return q;
    }

    public int contain(String name) {
        int pos = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                pos = i;
            }
        }
        return pos;
    }

}
