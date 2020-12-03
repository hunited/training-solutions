package week06d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Budget {

    List<Item> items;

    public Budget(List<Item> items) {
        if (items.isEmpty() || items == null) {
            throw new NullPointerException("A lista nem lehet üres!");
        }
        this.items = items;
    }

    public List<Item> getItemsByMonth(LocalDate date) {
        List<Item> filteredItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getDate().equals(date)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

}
