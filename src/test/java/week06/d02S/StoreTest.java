package week06.d02S;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StoreTest {

    @Test
    public void testStore() {
        Product product1 = new Product("Kenyér", Category.DAIRY, 220);
        Product product2 = new Product("Tej", Category.DAIRY, 280);
        Product product3 = new Product("Zsemle", Category.DAIRY, 30);
        Product product4 = new Product("Mexikói zöldségkeverék", Category.FROZEN, 649);
        List<Product> products = Arrays.asList(product1, product2, product3, product4);
        Store store = new Store();
        System.out.println(store.getProductsByCategory(products));
        assertEquals("FROZEN: 1 db.\nDAIRY: 3 db.\nBAKEDGOODS: 0 db.\nOTHER: 0 db.\n", store.getProductsByCategory(products));
    }

    @Test
    public void testStoreNullList() throws NullPointerException {
        Product product1 = new Product("Kenyér", Category.DAIRY, 220);
        Exception ex = assertThrows(NullPointerException.class, () -> new Store().getProductsByCategory(null));
        assertEquals("A terméklista nem lehet üres!", ex.getMessage());
    }

    @Test
    public void testStoreNoList() throws NullPointerException {
        Product product1 = new Product("Kenyér", Category.DAIRY, 220);
        Exception ex = assertThrows(NullPointerException.class, () -> new Store().getProductsByCategory(Arrays.asList()));
        assertEquals("A terméklista nem lehet üres!", ex.getMessage());
    }

}
