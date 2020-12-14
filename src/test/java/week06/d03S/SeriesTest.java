package week06.d03S;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeriesTest {

    @Test
    public void testSeriesAsc() {
        Series s = new Series();
        assertEquals(SeriesType.ASCENDING, s.calculateSeriesType(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void testSeriesDesc() {
        Series s = new Series();
        assertEquals(SeriesType.DESCENDING, s.calculateSeriesType(Arrays.asList(6, 5, 4, 3, 2, 1)));
    }

    @Test
    public void testSeriesOther() {
        Series s = new Series();
        assertEquals(SeriesType.OTHER, s.calculateSeriesType(Arrays.asList(6, 7, 4, 3, 8, 1)));
    }

    @Test
    public void testSeriesToSmall() {
        Series s = new Series();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> s.calculateSeriesType(Arrays.asList(1)));
        assertEquals("Legalább két elem kell a listába!", ex.getMessage());
    }

    @Test
    public void testSeriesEmpty() {
        Series s = new Series();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> s.calculateSeriesType(null));
        assertEquals("Legalább két elem kell a listába!", ex.getMessage());
    }

}
