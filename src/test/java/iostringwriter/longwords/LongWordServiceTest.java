package iostringwriter.longwords;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LongWordServiceTest {

    LongWordService longWordService = new LongWordService();

    @Test
    void writeWithStringWriterTest() {
        List<String> testWords = List.of("Pseudopseudohypoparathyroidism",
                "Supercalifragilisticexpialidocious",
                "Strengths");
        String s = longWordService.writeWithStringWriter(testWords);
        String[] testS = s.split("\n");
        assertEquals(3, testS.length);
        assertTrue(testS[1].contains("34"));
    }

}
