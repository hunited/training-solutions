package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    private static final String NAME_AND_PW = "activitytracker";

    private ActivityDao dao;

    private final TrackPoint tp1 = new TrackPoint(LocalDateTime.parse("2021-02-01T13:08"), 47.5950470, 19.3407574);
    private final TrackPoint tp2 = new TrackPoint(LocalDateTime.parse("2021-02-01T14:52"), 47.6034720, 19.3502194);
    private final TrackPoint tp3 = new TrackPoint(LocalDateTime.parse("2021-02-01T15:47"), 47.5665321, 19.3837357);
    private final TrackPoint tp4 = new TrackPoint(LocalDateTime.parse("2021-02-01T16:31"), 47.5826489, 19.2500236);
    private final TrackPoint tp5 = new TrackPoint(LocalDateTime.parse("2021-02-01T17:29"), 47.6447091, 19.3304097);

    private final Activity activity1 = new Activity(LocalDateTime.parse("2021-02-01T13:08"),
            "Futás az Erzsébet parkban", ActivityType.RUNNING, List.of(tp1, tp2, tp3, tp4, tp5));
    private final Activity activity2 = new Activity(LocalDateTime.parse("2021-02-02T14:52"),
            "Kosár a Rönkös játszótéren", ActivityType.BASKETBALL);
    private final Activity activity3 = new Activity(LocalDateTime.parse("2021-02-03T15:47"),
            "Túra az Arborétumban", ActivityType.HIKING);
    private final Activity activity4 = new Activity(LocalDateTime.parse("2021-02-04T16:31"),
            "Bringázás a Hungaroringhez", ActivityType.BIKING);
    private final Activity activity5 = new Activity(LocalDateTime.parse("2021-02-05T17:29"),
            "Túra a Margitára", ActivityType.HIKING);

    @BeforeEach
    void setUp() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser(NAME_AND_PW);
            dataSource.setPassword(NAME_AND_PW);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect to database", se);
        }
        dao = new ActivityDao(dataSource);
        Flyway flyway = Flyway.configure().locations("filesystem:src/main/resources/activitytracker").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void saveActivity() {
        Activity result = dao.saveActivity(activity1);
        assertEquals(1, result.getId());
        assertEquals(5, result.getTrackPoints().size());
    }

    @Test
    void saveActivityWithError() {
        assertThrows(IllegalArgumentException.class, () -> dao.saveActivity(
                new Activity(LocalDateTime.parse("2021-02-03T15:47"), "Túra az Arborétumban", ActivityType.HIKING,
                        List.of(tp1, new TrackPoint(LocalDateTime.parse("2021-05-02T15:47"), 181.5950470, 46.3407574))
                )
        ));
        assertEquals(0, dao.listActivities().size());
    }

    @Test
    void findActivityById() {
        dao.saveActivity(activity1);
        Activity result = dao.findActivityById(activity1.getId());
        assertEquals(activity1, result);
    }

    @Test
    void listActivities() {
        dao.saveActivity(activity1);
        dao.saveActivity(activity2);
        dao.saveActivity(activity3);
        dao.saveActivity(activity4);
        dao.saveActivity(activity5);
        List<Activity> asserted = List.of(activity1, activity2, activity3, activity4, activity5);
        assertEquals(asserted, dao.listActivities());
    }

    @Test
    void someTrackPoints() {
        dao.saveActivity(activity1);
        List<TrackPoint> asserted = List.of(tp1, tp3, tp5);
        List<TrackPoint> result = dao.someTrackPoints(activity1.getId());
        assertEquals(asserted, result);
    }

    @Test
    void someTrackPointsTwo() {
        Activity test = new Activity(LocalDateTime.parse("2021-02-01T13:08"),
                "Futás az Erzsébet parkban", ActivityType.RUNNING, List.of(tp1, tp2));
        dao.saveActivity(test);
        List<TrackPoint> asserted = List.of(tp1, tp2);
        List<TrackPoint> result = dao.someTrackPoints(test.getId());
        assertEquals(asserted, result);
    }

    @Test
    void someTrackPointsFour() {
        Activity test = new Activity(LocalDateTime.parse("2021-02-01T13:08"),
                "Futás az Erzsébet parkban", ActivityType.RUNNING, List.of(tp1, tp2, tp3, tp4));
        dao.saveActivity(test);
        List<TrackPoint> asserted = List.of(tp1, tp2, tp4);
        List<TrackPoint> result = dao.someTrackPoints(test.getId());
        assertEquals(asserted, result);
    }

    @Test
    void someTrackPointsEmpty() {
        dao.saveActivity(activity2);
        List<TrackPoint> asserted = List.of();
        List<TrackPoint> result = dao.someTrackPoints(activity2.getId());
        assertEquals(asserted, result);
    }

    @Test
    void saveImageToActivity() {
        dao.saveActivity(activity1);
        long id = dao.saveImageToActivity(activity1.getId(), new Image("filename.jpg", new byte[]{'a', 's', 'd', '1'}));
        assertEquals(1, id);
    }

    @Test
    void loadImageToActivity() {
        dao.saveActivity(activity1);
        dao.saveImageToActivity(activity1.getId(), new Image("filename.jpg", new byte[]{'a', 's', 'd', '1'}));
        Image asserted = new Image(1, "filename.jpg", new byte[]{'a', 's', 'd', '1'});
        Image result = dao.loadImageToActivity(activity1.getId(), "filename.jpg");
        assertEquals(asserted, result);
    }

}
