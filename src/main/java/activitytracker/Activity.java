package activitytracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Activity {

    private long id;
    private final LocalDateTime startTime;
    private final String desc;
    private final ActivityType type;
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public Activity(long id, LocalDateTime startTime, String desc, ActivityType type) {
        this(startTime, desc, type);
        this.id = id;
    }

    public Activity(LocalDateTime startTime, String desc, ActivityType type) {
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public Activity(LocalDateTime startTime, String desc, ActivityType type, List<TrackPoint> trackPoints) {
        this(startTime, desc, type);
        this.trackPoints = trackPoints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public ActivityType getType() {
        return type;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void setTrackPoints(List<TrackPoint> trackPoints) {
        this.trackPoints = trackPoints;
    }

    @Override
    public String toString() {
        if (trackPoints.isEmpty()) {
            return "Activity id: " + id + ", startTime: " + startTime + ", desc: " + desc + ", type: " + type + ".";
        } else {
            return "Activity id: " + id + ", startTime: " + startTime + ", desc: " + desc + ", type: " + type + ", TrackPoints: " + trackPoints + ".";
        }
    }

}
