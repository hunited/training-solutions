package week05d05S;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    List<Song> songs;

    public Playlist(List<Song> songs) {
        if (songs == null || songs.size() == 0) {
            throw new IllegalArgumentException("A lejátszási lista üres!");
        }
        this.songs = songs;
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        int MIN = 60;
        List<Song> found = new ArrayList<>();
        for (Song song : songs) {
            if ((song.getLengthInSeconds() / MIN) >= mins) {
                found.add(song);
            }
        }
        if (found == null || found.size() == 0) {
            throw new NullPointerException("Nincs ilyen hosszú szám!");
        }
        return found;
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        String msg = "";
        for (int i = 0; i < songs.size(); i++) {
            msg = msg.concat(songs.get(i).toString());
            if (i != songs.size() - 1) {
                msg = msg.concat("\n");
            }
        }
        return msg;
    }

}