package week06.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BiscuitTest {

    @Test
    public void tesztBottle() {
        Biscuit b = new Biscuit(BiscuitType.HAZTARTASIKEKSZ, 250);
        assertEquals(250, b.getGramAmount());
    }

    @Test
    public void tesztBottleFill() {
        Biscuit b = Biscuit.of(BiscuitType.HAZTARTASIKEKSZ, 250);
        assertEquals(250, b.getGramAmount());
    }

    @Test
    public void tesztBottleNoFill() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Biscuit(BiscuitType.HAZTARTASIKEKSZ, 0));
        assertEquals("A mennyiség nem lehet egynél kevesebb!", ex.getMessage());
    }

}
