package week10.d01S;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingFileTest {

    InputStream is = HikingFile.class.getResourceAsStream("gps.txt");
    HikingFile hf = new HikingFile();
    List<Integer> result = hf.getPlusElevation(is);

    @Test
    void getPlusElevation() {
        assertEquals(13, result.get(0));
        assertEquals(5, result.get(1));
    }

    @Test
    void getPositions() {
        assertEquals(4, hf.getPositions().size());
    }

}
