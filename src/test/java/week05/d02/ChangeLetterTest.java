package week05.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {

    @Test
    public void testGrading() {
        ChangeLetter cl = new ChangeLetter();
        assertEquals("*lb*rt*rs*", cl.changeVowels("Albertirsa"));
        assertEquals("B*d*p*st", cl.changeVowels("Budapest"));
    }

}
