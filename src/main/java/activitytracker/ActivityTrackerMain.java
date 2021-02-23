package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class ActivityTrackerMain {

    private static final String NAME_AND_PW = "activitytracker";

    public static void main(String[] args) {
        ActivityDao dao = new ActivityDao(createDataSource());
        for (Activity activity : createActivities()) {
            dao.saveActivity(activity);
        }
        List<Activity> activities = dao.listActivities();
        for (Activity activity : activities) {
            System.out.println(activity);
        }
    }

    private static MariaDbDataSource createDataSource() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser(NAME_AND_PW);
            dataSource.setPassword(NAME_AND_PW);
            return dataSource;
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect to database", se);
        }
    }

    private static List<Activity> createActivities() {
        Activity activity1 = new Activity(LocalDateTime.parse("2021-02-01T13:08"), "Futás az Erzsébet parkban", ActivityType.RUNNING);
        Activity activity2 = new Activity(LocalDateTime.parse("2021-02-02T14:52"), "Kosár a Rönkös játszótéren", ActivityType.BASKETBALL);
        Activity activity3 = new Activity(LocalDateTime.parse("2021-02-03T15:47"), "Túra az Arborétumban", ActivityType.HIKING);
        Activity activity4 = new Activity(LocalDateTime.parse("2021-02-04T16:31"), "Bringázás a Hungaroringhez", ActivityType.BIKING);
        Activity activity5 = new Activity(LocalDateTime.parse("2021-02-05T17:29"), "Túra a Margitára", ActivityType.HIKING);
        Activity activity6 = new Activity(LocalDateTime.parse("2021-02-06T08:43"), "Bringázás a park kerékpárpályához", ActivityType.BIKING);
        Activity activity7 = new Activity(LocalDateTime.parse("2021-02-07T09:15"), "Futás a kutya után", ActivityType.RUNNING);
        Activity activity8 = new Activity(LocalDateTime.parse("2021-02-08T10:24"), "Kosár a haverokkal a suliban", ActivityType.BASKETBALL);
        Activity activity9 = new Activity(LocalDateTime.parse("2021-02-09T11:56"), "Futás az életemért a szavannán", ActivityType.RUNNING);
        return List.of(activity1, activity2, activity3, activity4, activity5, activity6, activity7, activity8, activity9);
    }

}
