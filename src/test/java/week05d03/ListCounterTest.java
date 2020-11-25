package week05d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {
    @Test
    public void testCounter() {
        ListCounter lc = new ListCounter();
        // Találat 4
        assertEquals(4, lc.listCounter(Arrays.asList("Alma", "Körte", "Cseresznye", "Autó", "ananász", "almalé")));
    }

    @Test
    public void testCounterNotFound() {
        ListCounter lc = new ListCounter();
        // Találat 0
        assertEquals(0, lc.listCounter(Arrays.asList("Barack", "Körte", "Cseresznye", "bicikli", "citrom", "körtelé")));
    }

    @Test
    public void testCounterEmpty() {
        ListCounter lc = new ListCounter();
        // Üres lista
        assertEquals(0, lc.listCounter(Arrays.asList()));
    }

}
