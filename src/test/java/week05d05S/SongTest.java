package week05d05S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SongTest {

    @Test
    public void testSong() {
        Song song = new Song("Ahol a hegyeket látod", 202, "Road");
        assertEquals("Ahol a hegyeket látod (Road, 202 mp)", song.toString());
    }

    @Test
    public void testSongNoLenght() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Song("Ahol a hegyeket látod", 0, "Road"));
        assertEquals("A szám hossza nem lehet nulla vagy kisebb!", ex.getMessage());
    }

    @Test
    public void testSongNoName() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> new Song("", 202, "Road"));
        assertEquals("A név és az előadó nem lehet üres!", ex.getMessage());
    }

    @Test
    public void testSongNoArtist() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> new Song("Ahol a hegyeket látod", 202, ""));
        assertEquals("A név és az előadó nem lehet üres!", ex.getMessage());
    }

}