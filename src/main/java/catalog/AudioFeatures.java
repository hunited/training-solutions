package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private final String title;
    private final int length;
    private final List<String> performers;
    private final List<String> composer;

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        this.title = title;
        if (length < 1) {
            throw new IllegalArgumentException("Non valid length");
        }
        this.length = length;
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("Empty title");
        }
        this.performers = performers;
        this.composer = composer;
    }

    public AudioFeatures(String title, int length, List<String> performers) {
        this(title, length, performers, null);
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        if (composer != null) {
            contributors.addAll(composer);
        }
        contributors.addAll(performers);
        return contributors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

}
