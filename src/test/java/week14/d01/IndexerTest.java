package week14.d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IndexerTest {

    @Test
    void index() {
        Map<Character, List<String>> test = new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna", "Lajos"));
        Map<Character, List<String>> expected = Map.of(
                'A', Arrays.asList("Abraham"),
                'L', Arrays.asList("Lujza", "Lajos"),
                'O', Arrays.asList("Odon"),
                'M', Arrays.asList("Magdolna")
        );
        assertEquals(expected, test);
    }

}
