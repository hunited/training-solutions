package week13.d02;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    Airport ar = new Airport();

    @Test
    void readFromFile() {
        ar.readFromFile("cities.txt");
        assertEquals(100, ar.getFlies().size());
    }

    @Test
    void typeFinder() {
        ar.readFromFile("cities.txt");
        assertEquals("Departure", ar.typeFinder());
    }

    @Test
    void flyFinder() {
        ar.readFromFile("cities.txt");
        Fly fly = ar.flyFinder("JP2694");
        assertEquals("JP2694", fly.getName());
        assertEquals("Departure", fly.getType());
        assertEquals("Oslo", fly.getTarget());
        assertEquals(LocalTime.of(7,57), fly.getTime());
    }

    @Test
    void flyFinderError() {
        ar.readFromFile("cities.txt");
        assertThrows(IllegalArgumentException.class, () -> ar.flyFinder("P2694"));
    }

    @Test
    void flyFinderByCityAndType() {
        ar.readFromFile("cities.txt");
        assertEquals(3, ar.flyFinderByCityAndType("Dublin", "Arrival").size());
    }

    @Test
    void flyFinderByCityAndTypeError() {
        ar.readFromFile("cities.txt");
        assertThrows(IllegalArgumentException.class, () -> ar.flyFinderByCityAndType("Tokyo", "Departure"));
    }

    @Test
    void earlierFly() {
        ar.readFromFile("cities.txt");
        Fly fly = ar.earlierFly();
        assertEquals("BJ2309", fly.getName());
        assertEquals("Departure", fly.getType());
        assertEquals("Stockholm", fly.getTarget());
        assertEquals(LocalTime.of(7,57), fly.getTime());
    }

}