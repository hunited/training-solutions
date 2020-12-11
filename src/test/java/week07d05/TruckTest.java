package week07d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    @Test
    public void testTruck() {
        Truck truck = new Truck();
        assertEquals(5, truck.getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, truck.getTransmissionType());
    }

    @Test
    public void testTruck2() {
        Truck truck = new Truck(4,TransmissionType.SEQUENTIAL);
        assertEquals(4, truck.getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, truck.getTransmissionType());
    }

}