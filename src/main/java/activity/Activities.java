package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private final List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        return reports;
    }

    public int numberOfTrackActivities() {
        return 0;
    }

    public int numberOfWithoutTrackActivities() {
        return 0;
    }

}
