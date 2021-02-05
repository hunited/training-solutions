package week14.d05;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HachikoTest {

    @Test
    void countWordsTest() {
        Hachiko h = new Hachiko();
        Map<String, Integer> result = h.countWords("hachiko.srt", "Hachiko", "haza", "pályaudvar", "jó");
        assertEquals(4, result.get("Hachiko"));
        assertEquals(15, result.get("haza"));
        assertEquals(5, result.get("pályaudvar"));
        assertEquals(15, result.get("jó"));
    }

}