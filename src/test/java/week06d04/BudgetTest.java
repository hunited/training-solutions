package week06d04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BudgetTest {

    private Budget budget;

    Item i1 = new Item(100, LocalDate.of(2020, 11, 05), "kenyér");
    Item i2 = new Item(200, LocalDate.of(2020, 7, 05), "tej");
    Item i3 = new Item(300, LocalDate.of(2020, 6, 05), "szalámi");
    Item i4 = new Item(400, LocalDate.of(2020, 5, 05), "vaj");
    Item i5 = new Item(500, LocalDate.of(2020, 4, 05), "üdítő");

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void tesztBudget() {
        assertEquals("[kenyér (100 Ft), ekkor: 2020-11-05.]", new Budget(Arrays.asList(i1, i2, i3, i4, i5)).getItemsByMonth(LocalDate.of(2020, 11, 05)).toString());
    }

    @Test
    public void tesztBudgetNoList() {
        Exception ex = assertThrows(NullPointerException.class, () -> new Budget(Arrays.asList()));
        assertEquals("A lista nem lehet üres!", ex.getMessage());
    }

}
