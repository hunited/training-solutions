package week08.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    public void testTrainerGoodMood() {
        Trainer t = new Trainer(new GoodMood());
        assertEquals(5,t.giveMark());
    }

    @Test
    public void testTrainerBadMood() {
        Trainer t = new Trainer(new BadMood());
        assertEquals(3,t.giveMark());
    }

}
