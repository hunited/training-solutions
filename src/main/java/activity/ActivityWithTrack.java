package activity;

public class ActivityWithTrack implements Activity {

    private final Track track;
    private final ActivityType activityType;

    public ActivityWithTrack(Track track, ActivityType activityType) {
        this.track = track;
        this.activityType = activityType;
    }

    @Override
    public double getDistance() {
        return track.getDistance();
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }

}
