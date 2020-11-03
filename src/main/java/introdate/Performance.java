package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Performance {

    private LocalDate date;
    private String artist;
    private LocalTime startTime;
    private LocalTime endTime;

    public Performance(int year, int month, int day, String artist, int startHour, int startMin, int endHour, int endMin) {
        this.date = LocalDate.of(year, month, day);
        this.artist = artist;
        this.startTime = LocalTime.of(startHour, startMin);
        this.endTime = LocalTime.of(endHour, endMin);
    }

    public String getInfo() {
        return getArtist() + ": " + getDate() + " " + getStartTime() + " - " + getEndTime();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getArtist() {
        return artist;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
