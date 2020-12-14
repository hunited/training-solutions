package week05.d05S;

public class Song {

    private String name;

    private long lengthInSeconds;

    private String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        isEmpty(name, artist);
        isNull(lengthInSeconds);
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    public void isEmpty(String s1, String s2) {
        if (s1 == null || s2 == null || "".equals(s1) || "".equals(s2)) {
            throw new NullPointerException("A név és az előadó nem lehet üres!");
        }
    }

    public void isNull(long lis) {
        if (lis < 1) {
            throw new IllegalArgumentException("A szám hossza nem lehet nulla vagy kisebb!");
        }
    }

    @Override
    public String toString() {
        return name + " (" + artist + ", " + lengthInSeconds + " mp)";
    }
}
