package week06d04S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    public void tesztShoppingCart() {
        ShoppingCart sc = new ShoppingCart();
        sc.addItem("Kenyér", 1);
        sc.addItem("Kenyér", 1);
        sc.addItem("Tej", 1);
        assertEquals(2, sc.getList().size());
        assertEquals(2, sc.getItem("Kenyér"));
        assertEquals(0, sc.getItem("Hagyma"));
        assertEquals("Kenyér", sc.getList().get(0).getName());
        assertEquals("Tej", sc.getList().get(1).getName());
    }

}
