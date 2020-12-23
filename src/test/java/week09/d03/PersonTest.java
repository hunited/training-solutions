package week09.d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    SantaClaus sc;

    @BeforeEach
    public void init() {
        Person anita = new Person("Anita", 36);
        Person emese = new Person("Emese", 8);
        Person sanyi = new Person("Sanyi", 40);
        Person hunor = new Person("Hunor", 10);

        sc = new SantaClaus(List.of(anita, emese, sanyi, hunor));
        sc.getThroughChimneys();
    }

    @Test
    void testPresent() {
        String result = "Karácsonyi ajándékok: [Anita(36) ajándéka: Electronic, Emese(8) ajándéka: Toy, Sanyi(40) ajándéka: Electronic, Hunor(10) ajándéka: Toy].";
        assertEquals(result, sc.toString());
    }

    @Test
    void testPresentName() {
        assertEquals("Anita", sc.getPersonList().get(0).getName());
    }

    @Test
    void testPresentAge() {
        assertEquals(36, sc.getPersonList().get(0).getAge());
    }

    @Test
    void testPresentType() {
        assertEquals(Present.Electronic, sc.getPersonList().get(0).getPresent());
    }

}