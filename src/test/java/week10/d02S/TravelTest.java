package week10.d02S;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {

    @Test
    void getStopWithMax() {
        InputStream is = Travel.class.getResourceAsStream("utasadat.txt");
        assertEquals(0, new Travel().getStopWithMax(is));
    }

}
