package week06d01S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeparatedSumTest {

    @Test
    public void testSeparatedSum() {
        SeparatedSum ss = new SeparatedSum();
        ResultPosNeg test = ss.sum("1,2;-2,4;3,6;-4,8;6,0;-7,2;8,4");
        assertEquals(19.2, test.getPositive(), 0.005);
        assertEquals(-14.4, test.getNegative(), 0.005);
    }

    @Test
    public void testSeparatedSumEmpty() {
        SeparatedSum ss = new SeparatedSum();
        ResultPosNeg test = ss.sum("");
        assertEquals(0.0, test.getPositive(), 0.005);
        assertEquals(0.0, test.getNegative(), 0.005);
    }

    @Test
    public void testSeparatedSumNull() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> new SeparatedSum().sum(null));
        assertEquals("A lista null!", ex.getMessage());
    }

}
