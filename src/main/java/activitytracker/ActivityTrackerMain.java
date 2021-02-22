package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    private static final String NAME_AND_PW = "activitytracker";
    private final MariaDbDataSource dataSource = new MariaDbDataSource();

    public static void main(String[] args) {
        ActivityTrackerMain main = new ActivityTrackerMain();
        main.connectToDb();
        List<Integer> ids = new ArrayList<>();
        for (Activity activity : createActivities()) {
            ids.add(main.fillDb(activity));
        }
        for (Integer id : ids) {
            System.out.println(main.findActivityById(id));
        }
    }

    private static List<Activity> createActivities() {
        Activity activity1 = new Activity(1, LocalDateTime.parse("2021-02-01T13:08"), "Futás az Erzsébet parkban", ActivityType.RUNNING);
        Activity activity2 = new Activity(1, LocalDateTime.parse("2021-02-02T14:52"), "Kosár a Rönkös játszótéren", ActivityType.BASKETBALL);
        Activity activity3 = new Activity(1, LocalDateTime.parse("2021-02-03T15:47"), "Túra az Arborétumban", ActivityType.HIKING);
        Activity activity4 = new Activity(1, LocalDateTime.parse("2021-02-04T16:31"), "Bringázás a Hungaroringhez", ActivityType.BIKING);
        Activity activity5 = new Activity(1, LocalDateTime.parse("2021-02-05T17:29"), "Túra a Margitára", ActivityType.HIKING);
        Activity activity6 = new Activity(1, LocalDateTime.parse("2021-02-06T08:43"), "Bringázás a park kerékpárpályához", ActivityType.BIKING);
        Activity activity7 = new Activity(1, LocalDateTime.parse("2021-02-07T09:15"), "Futás a kutya után", ActivityType.RUNNING);
        Activity activity8 = new Activity(1, LocalDateTime.parse("2021-02-08T10:24"), "Kosár a haverokkal a suliban", ActivityType.BASKETBALL);
        Activity activity9 = new Activity(1, LocalDateTime.parse("2021-02-09T11:56"), "Futás az életemért a szavannán", ActivityType.RUNNING);
        return List.of(activity1, activity2, activity3, activity4, activity5, activity6, activity7, activity8, activity9);
    }

    private void connectToDb() {
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser(NAME_AND_PW);
            dataSource.setPassword(NAME_AND_PW);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect to database", se);
        }
    }

    private int fillDb(Activity activity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO `activities` (`start_time`, `activity_desc`, `activity_type`) VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS
             )) {
            statement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            statement.setString(2, activity.getDesc());
            statement.setString(3, activity.getType().toString());
            statement.executeUpdate();
            return getIdByStatement(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    private int getIdByStatement(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.getGeneratedKeys()) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            throw new IllegalStateException("Can not get ID");
        }
    }

    public Activity findActivityById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM `activities` WHERE `id` = ?")) {
            statement.setInt(1, id);
            return selectNameByResultSet(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select activity", se);
        }
    }

    private static Activity selectNameByResultSet(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return new Activity(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("start_time").toLocalDateTime(),
                        resultSet.getString("activity_desc"),
                        ActivityType.valueOf(resultSet.getString("activity_type"))
                );
            } else {
                throw new IllegalArgumentException("Not found this id");
            }
        }
    }

}
