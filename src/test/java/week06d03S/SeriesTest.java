package week06d03S;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
