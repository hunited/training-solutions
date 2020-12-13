package catalog;

import java.util.List;

public class PrintedFeatures implements Feature {

    private String title;
    private int numberOfPages;
    private List<String> authors;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        this.title = title;
        if (numberOfPages < 1) {
            throw new IllegalArgumentException("Non valid number of pages");
        }
        this.numberOfPages = numberOfPages;
        if (Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("Empty authors");
        }
        this.authors = authors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public List<String> getContributors() {
        return authors;
    }
}
