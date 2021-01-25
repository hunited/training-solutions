package iowriter.music;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BandTest {

    private final Band band = new Band("Metallica", 1981);

    @Test
    void createBandTest() {
        assertEquals("Metallica", band.getName());
        assertEquals(1981, band.getYear());
    }

}
