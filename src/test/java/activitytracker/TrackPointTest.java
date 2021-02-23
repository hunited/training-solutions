package activitytracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrackPointTest {

    @Test
    void createTrackPoint() {
        TrackPoint trackPoint = new TrackPoint(
                1, LocalDate.parse("2021-02-01"), 47.5950470, 19.3407574
        );
        assertEquals(1, trackPoint.getId());
        assertEquals(LocalDate.parse("2021-02-01"), trackPoint.getTime());
        assertEquals(47.5950470, trackPoint.getLat());
        assertEquals(19.3407574, trackPoint.getLon());
    }

}