package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = Config.class)
class ActivityDaoSpringTest {

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

    @Autowired
    private Flyway flyway;

    @Autowired
    private ActivityDaoSpring daoSpring;

    @BeforeEach
    void setUp() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void saveActivity() {
        Activity result = daoSpring.saveActivity(activity1);
        assertEquals(1, result.getId());
        assertEquals(5, result.getTrackPoints().size());
    }

    @Test
    void saveActivityWithError() {
        assertThrows(IllegalArgumentException.class, () -> daoSpring.saveActivity(
                new Activity(LocalDateTime.parse("2021-02-03T15:47"), "Túra az Arborétumban", ActivityType.HIKING,
                        List.of(tp1, new TrackPoint(LocalDateTime.parse("2021-05-02T15:47"), 181.5950470, 46.3407574))
                )
        ));
        assertEquals(0, daoSpring.listActivities().size());
    }

    @Test
    void findActivityById() {
        daoSpring.saveActivity(activity1);
        Activity result = daoSpring.findActivityById(activity1.getId());
        assertEquals(activity1, result);
    }

    @Test
    void listActivities() {
        daoSpring.saveActivity(activity1);
        daoSpring.saveActivity(activity2);
        daoSpring.saveActivity(activity3);
        daoSpring.saveActivity(activity4);
        daoSpring.saveActivity(activity5);
        List<Activity> asserted = List.of(activity1, activity2, activity3, activity4, activity5);
        assertEquals(asserted, daoSpring.listActivities());
    }

    @Test
    void saveImageToActivity() {
        daoSpring.saveActivity(activity1);
        long id = daoSpring.saveImageToActivity(activity1.getId(), new Image("filename.jpg", new byte[]{'a', 's', 'd', '1'}));
        assertEquals(1, id);
    }

    @Test
    void loadImageToActivity() {
        daoSpring.saveActivity(activity1);
        daoSpring.saveImageToActivity(activity1.getId(), new Image("filename.jpg", new byte[]{'a', 's', 'd', '1'}));
        Image asserted = new Image(1, "filename.jpg", new byte[]{'a', 's', 'd', '1'});
        Image result = daoSpring.loadImageToActivity(activity1.getId(), "filename.jpg");
        assertEquals(asserted, result);
    }

}
