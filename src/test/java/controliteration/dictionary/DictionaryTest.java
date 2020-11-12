package controliteration.dictionary;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryTest {

    @Test
    void testAddItem() {

        DictionaryItem dictionaryItem = new DictionaryItem("Szia", Arrays.asList("Hi", "Hello", "Bye"));
        assertEquals("Szó: Szia, fordítások: [Hi, Hello, Bye]", dictionaryItem.toString());

    }

    @Test
    void testAddItemToString() {

        Dictionary dictionary = new Dictionary();

        dictionary.addItem("Szia", Arrays.asList("Hi", "Hello", "Bye"));

        List<String> translations = dictionary.findTranslations("Szia");
        assertEquals("[Hi, Hello, Bye]", translations.toString());

    }

    @Test
    void testAddItemNewTranslate() {

        Dictionary dictionary = new Dictionary();

        dictionary.addItem("Szia", Arrays.asList("Hi", "Hello"));
        dictionary.addItem("Szia", Collections.singletonList("Bye"));

        List<String> translations = dictionary.findTranslations("Szia");
        assertEquals(Arrays.asList("Hi", "Hello", "Bye"), translations);

    }

    @Test
    void testAddItemHasTranslate() {

        Dictionary dictionary = new Dictionary();

        dictionary.addItem("Szia", Arrays.asList("Hi", "Hello"));
        dictionary.addItem("Szia", Collections.singletonList("Bye"));
        dictionary.addItem("Szia", Collections.singletonList("Bye"));

        List<String> translations = dictionary.findTranslations("Szia");
        assertEquals(Arrays.asList("Hi", "Hello", "Bye"), translations);

    }

}
