package week06.d05S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BottleTest {

    @Test
    public void tesztBottle() {
        Bottle b = new Bottle(BottleType.GLASS_BOTTLE, 250);
        assertEquals(250, b.getFilledUnit());
    }

    @Test
    public void tesztBottleFill() {
        Bottle b = new Bottle(BottleType.GLASS_BOTTLE, 250);
        b.fill(50);
        assertEquals(300, b.getFilledUnit());
    }

    @Test
    public void tesztBottleErr() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Bottle(BottleType.GLASS_BOTTLE, 300).fill(1));
        assertEquals("Túlcsordult!", ex.getMessage());
    }

    @Test
    public void tesztBottleNoFill() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Bottle(BottleType.GLASS_BOTTLE, 0));
        assertEquals("A mennyiség nem lehet egynél kevesebb!", ex.getMessage());
    }

}
