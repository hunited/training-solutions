package week07d04;

import java.time.LocalTime;

public class Lab {

    private String title;
    private boolean completed;
    private LocalTime completedAt;

    public Lab(String title, LocalTime completedAt) {
        this.title = title;
        this.completedAt = completedAt;
        completed = true;
    }

    public Lab(String title) {
        this.title = title;
        completed = false;
    }

    public void complete(LocalTime date) {
        this.completed = true;
        this.completedAt = date;
    }

    public void complete() {
        this.completed = true;
        this.completedAt = LocalTime.now().withSecond(0).withNano(0);
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalTime getCompletedAt() {
        return completedAt;
    }

    @Override
    public String toString() {
        if (isCompleted()) {
            return "A(z) " +  title + " feladat elkészült ekkor: " + completedAt + ".";
        } else {
            return "A(z) " +  title + " feladat még nem készült el.";
        }
    }
}
