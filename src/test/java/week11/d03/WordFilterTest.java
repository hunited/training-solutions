package week11.d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordFilterTest {

    @Test
    void testWordFilter() {
        WordFilter wf = new WordFilter();
        List<String> testStrings = List.of("Egy", "Kettő", "Három", "Négy", "Öt", "Hat", "Hét");
        assertEquals(4, wf.wordsWithChar(testStrings, 't').size());
        assertEquals(1, wf.wordsWithChar(testStrings, 'E').size());
        assertEquals(0, wf.wordsWithChar(testStrings, 'x').size());
    }

    @Test
    void testWordFilterNull() {
        Exception ex = assertThrows(NullPointerException.class, () -> new WordFilter().wordsWithChar(null, 't'));
        assertEquals("A lista üres!", ex.getMessage());
    }

    @Test
    void testWordFilterEmpty() {
        Exception ex = assertThrows(NullPointerException.class, () -> new WordFilter().wordsWithChar(List.of(), 't'));
        assertEquals("A lista üres!", ex.getMessage());
    }

}