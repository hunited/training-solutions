package week05.d05S;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlaylistTest {

    @Test
    public void testPlaylist() {
        Song s01 = new Song("Ahol a hegyeket látod", 202, "Road");
        Song s02 = new Song("Nem kell más", 155, "Road");
        Song s03 = new Song("Túlzó kámfor illat", 271, "Road");
        Song s04 = new Song("Benzin legyen", 248, "Road");
        Song s05 = new Song("Onnantól-Eddig", 269, "Road");
        Playlist pl = new Playlist(Arrays.asList(s01, s02, s03, s04, s05));
        assertEquals("Ahol a hegyeket látod (Road, 202 mp)\n" +
                "Nem kell más (Road, 155 mp)\n" +
                "Túlzó kámfor illat (Road, 271 mp)\n" +
                "Benzin legyen (Road, 248 mp)\n" +
                "Onnantól-Eddig (Road, 269 mp)", pl.toString()
        );
    }

    @Test
    public void testPlaylistFindLenght() {
        Song s01 = new Song("Ahol a hegyeket látod", 202, "Road");
        Song s02 = new Song("Nem kell más", 155, "Road");
        Song s03 = new Song("Túlzó kámfor illat", 271, "Road");
        Song s04 = new Song("Benzin legyen", 248, "Road");
        Song s05 = new Song("Onnantól-Eddig", 269, "Road");
        Playlist pl = new Playlist(Arrays.asList(s01, s02, s03, s04, s05));
        assertEquals("[Túlzó kámfor illat (Road, 271 mp), " +
                "Benzin legyen (Road, 248 mp), " +
                "Onnantól-Eddig (Road, 269 mp)]", pl.findByLengthGreaterThan(4).toString()
        );
    }

    @Test
    public void testPlaylistLenghtNull() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Playlist(null));
        assertEquals("A lejátszási lista üres!", ex.getMessage());
    }

    @Test
    public void testPlaylistFindLenghtNull() throws NullPointerException {
        Song s01 = new Song("Ahol a hegyeket látod", 202, "Road");
        Song s02 = new Song("Nem kell más", 155, "Road");
        Song s03 = new Song("Túlzó kámfor illat", 271, "Road");
        Song s04 = new Song("Benzin legyen", 248, "Road");
        Song s05 = new Song("Onnantól-Eddig", 269, "Road");
        Playlist pl = new Playlist(Arrays.asList(s01, s02, s03, s04, s05));
        Exception ex = assertThrows(NullPointerException.class, () -> pl.findByLengthGreaterThan(5).toString());
        assertEquals("Nincs ilyen hosszú szám!", ex.getMessage());
    }

}