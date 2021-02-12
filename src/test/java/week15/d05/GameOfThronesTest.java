package week15.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfThronesTest {

    GameOfThrones got = new GameOfThrones();

    @Test
    void testMostIdiots() {
        assertEquals("Lannister", got.mostIdiotsHouse("battles.csv").getKey());
        assertEquals(18, got.mostIdiotsHouse("battles.csv").getValue());
    }

}