package week15.d03;

import java.time.LocalDate;

public class Post {

    private final String title;
    private final LocalDate publishedAt;
    private final String content;
    private final String owner;

    public Post(String title, LocalDate publishedAt, String content, String owner) {
        if (title == null || publishedAt == null || content == null || owner == null) {
            throw new NullPointerException("One or more parameter is null");
        }
        this.title = title;
        this.publishedAt = publishedAt;
        this.content = content;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public String getOwner() {
        return owner;
    }

}
