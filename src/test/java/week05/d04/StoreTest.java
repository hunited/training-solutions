package week05.d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    @Test
    public void testProductListAdd() {
        Store s = new Store();
        assertEquals(true, s.adProducts(new Product("Alma", 2020, 11, 28)));
    }

    @Test
    public void testProductListAddNonSucces() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Store s = new Store();
            new Product("", 2020, 11, 28);
            new Product("Alma", 2009, 11, 28);
            new Product("Körte", 2031, 11, 28);
        });
    }

    @Test
    public void testProductListExpired() {
        Store s = new Store();
        Product p1 = new Product("Alma", 2020, 11, 28);
        Product p2 = new Product("Körte", 2020, 12, 28);
        Product p3 = new Product("Szőlő", 2020, 11, 28);
        Product p4 = new Product("Cseresznye", 2021, 11, 28);
        assertEquals(2, s.getNumberOfExpired(Arrays.asList(p1, p2, p3, p4)));
    }

    @Test
    public void testProductListExpiredError() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Store s = new Store();
            Product p1 = new Product("Alma", 2009, 11, 28);
            Product p2 = new Product("Körte", 2020, 12, 28);
            Product p3 = new Product("Szőlő", 2020, 11, 28);
            Product p4 = new Product("Cseresznye", 2031, 11, 28);
            s.getNumberOfExpired(Arrays.asList(p1, p2, p3, p4));
        });
    }

}
