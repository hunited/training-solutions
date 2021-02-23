package activitytracker;

import java.time.LocalDate;

public class TrackPoint {

    private long id;
    private LocalDate time;
    private final double lat;
    private final double lon;

    public TrackPoint(long id, LocalDate time, double lat, double lon) {
        this(time, lat, lon);
        this.id = id;
    }

    public TrackPoint(LocalDate time, double lat, double lon) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public long getId() {
        return id;
    }

    public LocalDate getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "TrackPoint id: " + id + ", time: " + time + ", latitude: " + lat + ", longitude: " + lon + ".";
    }

}
