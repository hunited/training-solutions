package week16.d01;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class VowelFilterTest {

    @Test
    void testVowelFilter() {
        String asserted = """
                prcsk
                Klpcsk
                Bnn
                Cscsk
                Mcsk
                Mcsk
                """;
        VowelFilter vf = new VowelFilter();
        InputStream is = VowelFilter.class.getResourceAsStream("vowels.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            assertEquals(asserted, vf.filterVowels(br));
        } catch (IOException ioe) {
            throw new IllegalStateException("Something went wrong", ioe);
        }
    }

}
