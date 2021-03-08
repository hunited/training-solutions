package week07.d04S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    @Test
    void calculateSum() {
        long result = new ShoppingList().calculateSum("ShoppingList.csv");
        assertEquals(685, result);
    }

}
