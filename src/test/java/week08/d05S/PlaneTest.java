package week08.d05S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void getLongestOceanTrip() {
        Plane plane = new Plane();
        assertEquals(16, plane.getLongestOceanTrip());
    }

}
