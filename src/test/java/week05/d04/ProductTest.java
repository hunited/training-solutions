package week05.d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testProductAdd() {
        Product p1 = new Product("Alma", 2020, 11, 28);
        assertEquals("Alma", p1.getName());
    }

    @Test
    public void testProductAddNoValidNull() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Product p1 = new Product(null, 2020, 11, 28);
        });
    }

    @Test
    public void testProductAddNoValidEmpty() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Product p2 = new Product("", 2020, 11, 28);
        });
    }

    @Test
    public void testProductAddNoValidToOld() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Product p3 = new Product("Alma", 2009, 11, 28);
        });
    }

    @Test
    public void testProductAddNoValidToNew() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Product p4 = new Product("Körte", 2031, 11, 28);
        });
    }

}
