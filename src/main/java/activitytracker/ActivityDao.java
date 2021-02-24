package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private final MariaDbDataSource dataSource;

    public ActivityDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Activity saveActivity(Activity activity) {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            long id = processingActivity(connection, activity);
            processingTrackPoints(id, activity.getTrackPoints(), connection);
            connection.commit();
            activity.setId(id);
            return findActivityById(id);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public Activity findActivityById(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM `activities` WHERE `id` = ?;")) {
            statement.setLong(1, id);
            Activity result = getActivityByResultSet(statement);
            result.setTrackPoints(getTrackPoints(connection, result.getId()));
            return result;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect to db", se);
        }
    }

    public List<Activity> listActivities() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT `id` FROM `activities` ORDER BY `id`")) {
            List<Activity> activities = new ArrayList<>();
            while (resultSet.next()) {
                activities.add(findActivityById(resultSet.getLong(1)));
            }
            return activities;
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create activities", se);
        }
    }

    private long processingActivity(Connection connection, Activity activity) throws SQLException {
        try (PreparedStatement statementActivity = connection.prepareStatement(
                "INSERT INTO `activities` (`start_time`, `activity_desc`, `activity_type`) VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS
        )) {
            statementActivity.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            statementActivity.setString(2, activity.getDesc());
            statementActivity.setString(3, activity.getType().toString());
            statementActivity.executeUpdate();
            return getIdByStatement(statementActivity);
        }
    }

    private void processingTrackPoints(long id, List<TrackPoint> trackPoints, Connection connection) throws SQLException {
        try (PreparedStatement statementTrackPoint = connection.prepareStatement(
                "INSERT INTO `track_point` (`activity_id`, `time`, `lat`, `lon`) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS
        )) {
            for (TrackPoint trackPoint : trackPoints) {
                statementTrackPoint.setLong(1, id);
                statementTrackPoint.setTimestamp(2, Timestamp.valueOf(trackPoint.getTime().atStartOfDay()));
                statementTrackPoint.setDouble(3, trackPoint.getLat());
                statementTrackPoint.setDouble(4, trackPoint.getLon());
                statementTrackPoint.executeUpdate();
                trackPoint.setId(getIdByStatement(statementTrackPoint));
            }
        } catch (IllegalArgumentException iae) {
            connection.rollback();
        }
    }

    private long getIdByStatement(PreparedStatement statement) {
        try (ResultSet resultSet = statement.getGeneratedKeys()) {
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
            throw new IllegalStateException("Can not get ID");
        } catch (SQLException se) {
            throw new IllegalStateException("Something went wrong", se);
        }
    }

    private Activity getActivityByResultSet(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return new Activity(
                        resultSet.getLong("id"),
                        resultSet.getTimestamp("start_time").toLocalDateTime(),
                        resultSet.getString("activity_desc"),
                        ActivityType.valueOf(resultSet.getString("activity_type"))
                );
            } else {
                throw new IllegalArgumentException("Not found this id");
            }
        }
    }

    private List<TrackPoint> getTrackPoints(Connection connection, long id) throws SQLException {
        List<TrackPoint> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM `track_point` WHERE `activity_id` = ?;")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TrackPoint trackPoint = new TrackPoint(
                        resultSet.getLong("id"),
                        resultSet.getTimestamp("time").toLocalDateTime().toLocalDate(),
                        resultSet.getDouble("lat"),
                        resultSet.getDouble("lon")
                );
                result.add(trackPoint);
            }
        }
        return result;
    }

}
