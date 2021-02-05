package week14.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {

    Orders orders = new Orders();

    @BeforeEach
    void setUp() {
        orders.readFile(Path.of("src/main/resources/week14/d02/orders.txt"));
    }

    @Test
    void orderFinder() {
        assertEquals(4, orders.orderFinder("A233").size());
        assertEquals("bread", orders.orderFinder("A233").get(0));
    }

    @Test
    void productFinder() {
        assertEquals(2, orders.productFinder("rosmary"));
    }

    @Test
    void productFinderError() {
        assertThrows(IllegalArgumentException.class, () -> orders.productFinder("rosemary"));
    }

    @Test
    void numOfProductByName() {
        assertEquals(4, orders.numOfProductByName("A233"));
    }

    @Test
    void numOfProductByNameError() {
        assertThrows(IllegalArgumentException.class, () -> orders.numOfProductByName("A23"));
    }

    @Test
    void getOrderList() {
        assertEquals(9, orders.getOrderList().size());
    }

    @Test
    void getProductList() {
        assertEquals(27, orders.getProductList().size());
    }

}