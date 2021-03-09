package week08.d04S;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExamplesStoreTest {

    @Test
    void getTitlesOfExamples() {
        ExamplesStore es = new ExamplesStore();
        List<String> asserted = List.of("Első feladat", "Második feladat");
        assertEquals(asserted, es.getTitlesOfExamples());
    }
}