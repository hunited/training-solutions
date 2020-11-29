package week05d04S;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testProduct() {
        Product p1 = new Product(123456);
        assertEquals(411.52, p1.convertPrice(Product.CURRENCY.HUF));
    }

    @Test
    public void testProductNonValidCurrency() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Product p1 = new Product(123456);
            p1.convertPrice(null);
        });
    }

    @Test
    public void testProductNonValidProduct() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Product p1 = new Product(0);
        });
    }

}
