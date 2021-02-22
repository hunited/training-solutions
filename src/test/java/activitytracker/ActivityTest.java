package activitytracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {

    @Test
    void createActivity() {
        Activity activity = new Activity(
                1, LocalDateTime.parse("2021-02-01T13:08"), "Futás az Erzsébet parkban", ActivityType.RUNNING
        );
        assertEquals(1, activity.getId());
        assertEquals(LocalDateTime.parse("2021-02-01T13:08"), activity.getStartTime());
        assertEquals("Futás az Erzsébet parkban", activity.getDesc());
        assertEquals(ActivityType.RUNNING, activity.getType());
    }

}