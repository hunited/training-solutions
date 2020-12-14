package week06.d02S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    public void testProduct() {
        Product product1 = new Product("Kenyér", Category.DAIRY, 220);
        assertEquals("Product{name='Kenyér', category=DAIRY, price=220}", product1.toString());
    }

    @Test
    public void testProductNoName() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> new Product(null, Category.DAIRY, 220));
        assertEquals("A termék neve nem lehet Null!", ex.getMessage());
    }

    @Test
    public void testProductNoCategory() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> new Product("Kenyér", null, 220));
        assertEquals("A termék kategóriája nem lehet Null!", ex.getMessage());
    }

    @Test
    public void testProductNoPrice() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Product("Kenyér", Category.DAIRY, 0));
        assertEquals("A termék ára nem lehet nulla vagy kisebb!", ex.getMessage());
    }

}
