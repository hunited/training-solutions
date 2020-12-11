package week07d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    public void testVehicle() {
        Vehicle vehicle = new Vehicle();
        assertEquals(5, vehicle.getNumberOfGears());
        assertEquals(TransmissionType.MANUAL, vehicle.getTransmissionType());
    }

}