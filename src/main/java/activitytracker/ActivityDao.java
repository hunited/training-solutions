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
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statementActivity = connection.prepareStatement(
                     "INSERT INTO `activities` (`start_time`, `activity_desc`, `activity_type`) VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS
             )) {
            statementActivity.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            statementActivity.setString(2, activity.getDesc());
            statementActivity.setString(3, activity.getType().toString());
            statementActivity.executeUpdate();
            long id = getIdByStatement(statementActivity);
            activity.setId(id);
            processingTrackPoints(id, activity.getTrackPoints(), connection);
            return activity;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public Activity findActivityById(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM `activities` WHERE `id` = ?")) {
            statement.setLong(1, id);
            return selectActivityByResultSet(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect to db", se);
        }
    }

    public List<Activity> listActivities() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM `activities` ORDER BY `id`")) {
            List<Activity> activities = new ArrayList<>();
            while (resultSet.next()) {
                activities.add(getActivity(resultSet));
            }
            return activities;
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create activities", se);
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

    private void processingTrackPoints(long id, List<TrackPoint> trackPoints, Connection connection) throws SQLException {
        try (PreparedStatement statementTrackPoint = connection.prepareStatement(
                "INSERT INTO `track_point` (`activity_id`, `time`, `lat`, `lon`) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS
        )) {
            for (TrackPoint trackPoint : trackPoints) {
                processingTrackPointLine(statementTrackPoint, id, trackPoint);
            }
            connection.commit();
        } catch (IllegalArgumentException iae) {
            connection.rollback();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    private void processingTrackPointLine(PreparedStatement statementTrackPoint, long id, TrackPoint trackPoint) throws SQLException {
        if (trackPoint.getLat() > 90 || trackPoint.getLat() < -90 || trackPoint.getLon() > 180 || trackPoint.getLon() < -180) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
        statementTrackPoint.setLong(1, id);
        statementTrackPoint.setTimestamp(2, Timestamp.valueOf(trackPoint.getTime().atStartOfDay()));
        statementTrackPoint.setDouble(3, trackPoint.getLat());
        statementTrackPoint.setDouble(4, trackPoint.getLon());
        statementTrackPoint.executeUpdate();
    }

    private Activity selectActivityByResultSet(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return getActivity(resultSet);
            } else {
                throw new IllegalArgumentException("Not found this id");
            }
        }
    }

    private Activity getActivity(ResultSet resultSet) throws SQLException {
        return new Activity(
                resultSet.getLong("id"),
                resultSet.getTimestamp("start_time").toLocalDateTime(),
                resultSet.getString("activity_desc"),
                ActivityType.valueOf(resultSet.getString("activity_type"))
        );
    }

}
