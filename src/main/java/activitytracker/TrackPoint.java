package activitytracker;

import java.time.LocalDate;

public class TrackPoint {

    private long id;
    private final LocalDate time;
    private final double lat;
    private final double lon;

    public TrackPoint(long id, LocalDate time, double lat, double lon) {
        this(time, lat, lon);
        this.id = id;
    }

    public TrackPoint(LocalDate time, double lat, double lon) {
        this.time = time;
        if (lat > 90 || lat < -90) {
            throw new IllegalArgumentException("Invalid latitude");
        }
        this.lat = lat;
        if (lon > 180 || lon < -180) {
            throw new IllegalArgumentException("Invalid longitude");
        }
        this.lon = lon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
