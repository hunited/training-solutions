package week12.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CovidTest {

    @Test
    void covidFinderTest() {
        assertEquals(11, new Covid().covidFinder("index.html", "koronavírus"));
    }

}