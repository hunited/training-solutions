package introconstructors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {

    private List<String> menu;

    private String name;

    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.capacity = numberOfTables * 4;
        this.menu = menus();
    }

    private List<String> menus() {
        return Arrays.asList(
                "Vaníliás henger",
                "Vaníliás tégla",
                "Vaníliás kocka",
                "Vaníliás tetraéder",
                "Vaníliás oktaéder"
        );
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
