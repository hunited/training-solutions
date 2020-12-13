package catalog;

import java.util.Objects;

public class SearchCriteria {

    String title;
    String contributor;

    private SearchCriteria(String title, String contributor) {
        this.contributor = contributor;
        this.title = title;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Nem lehet üres!");
        }
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Nem lehet üres!");
        }
        return new SearchCriteria(title, contributor);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Nem lehet üres!");
        }
        return new SearchCriteria("", contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Nem lehet üres!");
        }
        return new SearchCriteria(title, "");
    }

    public boolean hasContributor() {
        return !Validators.isBlank(contributor);
    }

    public boolean hasTitle() {
        return !Validators.isBlank(title);
    }

    public String getTitle() {
        return title;
    }

    public String getContributor() {
        return contributor;
    }

}
