package week11.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    void testCouruerAdd() {
        Courier c = new Courier();
        c.addRide(new Ride(1, 1, 20));
        c.addRide(new Ride(1, 2, 20));
        c.addRide(new Ride(2, 1, 20));
        c.addRide(new Ride(4, 1, 20));
        c.addRide(new Ride(4, 2, 20));
        assertEquals(5, c.getRides().size());
    }

    @Test
    void testCouruerWrongInit() {
        Courier c = new Courier();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> c.addRide(new Ride(1, 2, 20)));
        assertEquals("Wrong Ride data", ex.getMessage());
    }

    @Test
    void testCouruerWrongDay() {
        Courier c = new Courier();
        c.addRide(new Ride(1, 1, 20));
        c.addRide(new Ride(1, 2, 20));
        c.addRide(new Ride(2, 1, 20));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> c.addRide(new Ride(1, 3, 20)));
        assertEquals("Wrong Ride data", ex.getMessage());
    }

    @Test
    void testCouruerWrongNumberOfRoad() {
        Courier c = new Courier();
        c.addRide(new Ride(1, 1, 20));
        c.addRide(new Ride(1, 2, 20));
        c.addRide(new Ride(2, 1, 20));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> c.addRide(new Ride(2, 3, 20)));
        assertEquals("Wrong Ride data", ex.getMessage());
    }

    @Test
    void testCouruerOffDay() {
        Courier c = new Courier();
        c.addRide(new Ride(1, 1, 20));
        c.addRide(new Ride(1, 2, 20));
        c.addRide(new Ride(2, 1, 20));
        c.addRide(new Ride(4, 1, 20));
        c.addRide(new Ride(4, 2, 20));
        assertEquals(3, c.firstOffDay());
    }

    @Test
    void testNoCouruerOffDay() {
        Courier c = new Courier();
        c.addRide(new Ride(1, 1, 20));
        c.addRide(new Ride(2, 1, 20));
        c.addRide(new Ride(3, 1, 20));
        c.addRide(new Ride(4, 1, 20));
        c.addRide(new Ride(5, 1, 20));
        c.addRide(new Ride(6, 1, 20));
        c.addRide(new Ride(7, 1, 20));
        assertEquals(-1, c.firstOffDay());
    }

    @Test
    void testGetDistance() {
        Courier c = new Courier();
        c.addRide(new Ride(1, 1, 20));
        assertEquals(20, c.getRides().get(0).getDistance());
    }

}