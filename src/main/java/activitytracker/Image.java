package activitytracker;

import java.util.Objects;

public class Image {

    private long id;
    private final String filename;
    private final byte[] content;

    public Image(long id, String filename, byte[] content) {
        this(filename, content);
        this.id = id;
    }

    public Image(String filename, byte[] content) {
        this.filename = filename;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public byte[] getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Image id: " + id + ", filename: " + filename + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;
        Image image = (Image) o;
        return id == image.id && Objects.equals(filename, image.filename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filename);
    }

}
