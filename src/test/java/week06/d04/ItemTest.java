package week06.d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {

    @Test
    public void tesztItem() {
        assertEquals("Kenyér (100 Ft), ekkor: 2020-11-05.", new Item(100, LocalDate.of(2020, 11, 05), "Kenyér").toString());
    }

    @Test
    public void tesztItemNoPrice() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Item(0, LocalDate.of(2020, 11, 05), "Kenyér"));
        assertEquals("Az ár nem lehet nulla vagy kisebb!", ex.getMessage());
    }

    @Test
    public void tesztItemNoName() {
        Exception ex = assertThrows(NullPointerException.class, () -> new Item(100, LocalDate.of(2020, 11, 05), null));
        assertEquals("A név nem lehet üres!", ex.getMessage());
    }

}
