package week06d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {

    @Test
    public void testListSelector() {
        ListSelector ls = new ListSelector();
        String test = ls.evenSelector(Arrays.asList("nulladik", "első", "második", "harmadik", "negyedik", "ötödik", "hatodik", "hetedik")).toString();
        assertEquals("[nulladik, második, negyedik, hatodik]", test);
    }

    @Test
    public void testListSelectorEmpty() {
        ListSelector ls = new ListSelector();
        String test = ls.evenSelector(Arrays.asList()).toString();
        assertEquals("", test);
    }

    @Test
    public void testListSelectorNull() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ListSelector().evenSelector(null));
        assertEquals("A lista null!", ex.getMessage());
    }

}
