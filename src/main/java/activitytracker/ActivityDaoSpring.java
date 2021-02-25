package activitytracker;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Objects;

public class ActivityDaoSpring {

    private final JdbcTemplate jdbcTemplate;

    public ActivityDaoSpring(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Activity saveActivity(Activity activity) {
        createActivity(activity);
        if (!activity.getTrackPoints().isEmpty()) {
            createTrackPoints(activity);
        }
        return findActivityById(activity.getId());
    }

    public Activity findActivityById(long id) {
        Activity activity = jdbcTemplate.queryForObject(
                "SELECT * FROM `activities` WHERE `id` = ?",
                (resultSet, rowNum) -> getActivity(resultSet), id
        );
        List<TrackPoint> tp = jdbcTemplate.query(
                "SELECT * FROM `track_point` WHERE `activity_id` = ?;",
                (resultSet, rowNum) -> getTrackPoint(resultSet), id
        );
        Objects.requireNonNull(activity).setTrackPoints(tp);
        return activity;
    }

    public List<Activity> listActivities() {
        return jdbcTemplate.query(
                "SELECT * FROM `activities` ORDER BY `id`",
                (resultSet, rowNum) -> findActivityById(resultSet.getLong("id"))
        );
    }

    public long saveImageToActivity(long activityId, Image image) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO `images`(`activity_id`, `filename`, `content`) VALUES (?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );
            Blob blob = connection.createBlob();
            blob.setBytes(1, image.getContent());
            statement.setLong(1, activityId);
            statement.setString(2, image.getFilename());
            statement.setBlob(3, blob);
            return statement;
        }, holder);
        long result = Objects.requireNonNull(holder.getKey()).longValue();
        image.setId(result);
        return result;
    }

    public Image loadImageToActivity(long activityId, String filename) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM `images` WHERE `activity_id` = ? AND `filename` = ?;",
                (resultSet, rowNum) -> getImage(resultSet), activityId, filename
        );
    }

    private void createActivity(Activity activity) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO `activities` (`start_time`, `activity_desc`, `activity_type`) VALUES (?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            statement.setString(2, activity.getDesc());
            statement.setString(3, activity.getType().toString());
            return statement;
        }, holder);
        activity.setId(Objects.requireNonNull(holder.getKey()).longValue());
    }

    private void createTrackPoints(Activity activity) {
        for (TrackPoint trackPoint : activity.getTrackPoints()) {
            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO `track_point` (`activity_id`, `time`, `lat`, `lon`) VALUES (?, ?, ?, ?);",
                        Statement.RETURN_GENERATED_KEYS
                );
                statement.setLong(1, activity.getId());
                statement.setTimestamp(2, Timestamp.valueOf(trackPoint.getTime()));
                statement.setDouble(3, trackPoint.getLat());
                statement.setDouble(4, trackPoint.getLon());
                return statement;
            }, holder);
            trackPoint.setId(Objects.requireNonNull(holder.getKey()).longValue());
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

    private TrackPoint getTrackPoint(ResultSet resultSet) throws SQLException {
        return new TrackPoint(
                resultSet.getLong("id"),
                resultSet.getTimestamp("time").toLocalDateTime(),
                resultSet.getDouble("lat"),
                resultSet.getDouble("lon")
        );
    }

    private Image getImage(ResultSet resultSet) throws SQLException {
        return new Image(
                resultSet.getLong("id"),
                resultSet.getString("filename"),
                resultSet.getBytes("content")
        );
    }

}
