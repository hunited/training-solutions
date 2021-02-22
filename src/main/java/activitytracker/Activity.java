package activitytracker;

import java.time.LocalDateTime;

public class Activity {

    private final int id;
    private final LocalDateTime startTime;
    private final String desc;
    private final ActivityType type;

    public Activity(int id, LocalDateTime startTime, String desc, ActivityType type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Activity id: " + id + ", startTime: " + startTime + ", desc: " + desc + ", type: " + type + ".";
    }

}
