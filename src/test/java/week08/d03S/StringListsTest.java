package week08.d03S;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {

    @Test
    void shortestWords() {
        StringLists sl = new StringLists();
        List<String> asserted = List.of("aa", "bb", "dd");
        assertEquals(asserted, sl.shortestWords(List.of("aaa", "aa", "bb", "cccc", "dd")));
    }

}
