package collectionsset.collectionstreeset;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.SortedSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordFilterTest {

    public final static String[] randomStrings = new String[]{"xyz", "cde", "klm", "cde"};

    @Test
    void checkSetSizeAndOrder() {
        Set<String> testSet = new WordFilter().filterWords(randomStrings);
        assertEquals(3, testSet.size());
        assertEquals("cde", ((SortedSet<String>) testSet).first());
        assertEquals("xyz", ((SortedSet<String>) testSet).last());
    }

}
