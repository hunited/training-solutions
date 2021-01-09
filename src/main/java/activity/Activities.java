package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private final List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = new ArrayList<>(activities);
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        ActivityType activityType;
        for (int i = 0; i < ActivityType.values().length; i++) {
            activityType = ActivityType.values()[i];
            double distance = 0;
            for (Activity activity : activities) {
                if (activity.getType().equals(ActivityType.values()[i])) {
                    distance += activity.getDistance();
                }
            }
            reports.add(new Report(activityType, distance));
        }
        return reports;
    }

    public int numberOfTrackActivities() {
        int result = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithTrack) {
                result++;
            }
        }
        return result;
    }

    public int numberOfWithoutTrackActivities() {
        return activities.size() - numberOfTrackActivities();
    }

}
