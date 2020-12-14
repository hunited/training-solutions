package week06.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordEraserTest {

    @Test
    public void testWordEraser() {
        assertEquals("körte birsalma cseresznye barack", new WordEraser().eraseWord("alma körte birsalma cseresznye barack alma", "alma"));
    }

    @Test
    public void testWordEraserEmpty() {
        Exception ex = assertThrows(NullPointerException.class, () -> new WordEraser().eraseWord("", "alma"));
        assertEquals("Üres a string!", ex.getMessage());

    }

    @Test
    public void testWordEraserNull() {
        Exception ex = assertThrows(NullPointerException.class, () -> new WordEraser().eraseWord("alma körte birsalma cseresznye barack alma", null));
        assertEquals("Üres a string!", ex.getMessage());
    }

}
