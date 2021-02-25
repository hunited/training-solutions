package activitytracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TrackPointTest {

    @Test
    void createTrackPoint() {
        TrackPoint trackPoint = new TrackPoint(
                1, LocalDateTime.parse("2021-02-01T13:08"), 47.5950470, 19.3407574
        );
        assertEquals(1, trackPoint.getId());
        assertEquals(LocalDateTime.parse("2021-02-01T13:08"), trackPoint.getTime());
        assertEquals(47.5950470, trackPoint.getLat());
        assertEquals(19.3407574, trackPoint.getLon());
    }

    @Test
    void createTrackPointError() {
        assertThrows(IllegalArgumentException.class, () -> new TrackPoint(
                1, LocalDateTime.parse("2021-02-01T13:08"), 181.5950470, 46.3407574
        ));
    }

}