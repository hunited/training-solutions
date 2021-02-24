package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    private static final String NAME_AND_PW = "activitytracker";

    private ActivityDao dao;

    private final TrackPoint tp1 = new TrackPoint(LocalDate.parse("2021-02-01"), 47.5950470, 19.3407574);
    private final TrackPoint tp2 = new TrackPoint(LocalDate.parse("2021-02-01"), 47.6034720, 19.3502194);
    private final TrackPoint tp3 = new TrackPoint(LocalDate.parse("2021-02-01"), 47.5665321, 19.3837357);
    private final TrackPoint tp4 = new TrackPoint(LocalDate.parse("2021-02-01"), 47.5826489, 19.2500236);
    private final TrackPoint tp5 = new TrackPoint(LocalDate.parse("2021-02-01"), 47.6447091, 19.3304097);

    private final Activity activity1 = new Activity(LocalDateTime.parse("2021-02-01T13:08"),
            "Futás az Erzsébet parkban", ActivityType.RUNNING, List.of(tp1, tp2, tp3));
    private final Activity activity2 = new Activity(LocalDateTime.parse("2021-02-02T14:52"),
            "Kosár a Rönkös játszótéren", ActivityType.BASKETBALL, List.of(tp4, tp5));
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
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void saveActivity() {
        Activity result = dao.saveActivity(activity1);
        assertEquals(1, result.getId());
        assertEquals(3, result.getTrackPoints().size());
    }

    @Test
    void saveActivityWithError() {
        assertThrows(IllegalArgumentException.class, () -> dao.saveActivity(
                new Activity(LocalDateTime.parse("2021-02-03T15:47"), "Túra az Arborétumban", ActivityType.HIKING,
                        List.of(tp1, new TrackPoint(LocalDate.parse("2021-05-02"), 181.5950470, 46.3407574))
                )
        ));
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

}
