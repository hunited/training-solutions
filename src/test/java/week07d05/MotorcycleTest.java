package week07d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {

    @Test
    public void testMotor() {
        Motorcycle motorcycle = new Motorcycle();
        assertEquals(5, motorcycle.getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, motorcycle.getTransmissionType());
    }

    @Test
    public void testMotor2() {
        Motorcycle motorcycle = new Motorcycle(4, TransmissionType.MANUAL);
        assertEquals(4, motorcycle.getNumberOfGears());
        assertEquals(TransmissionType.MANUAL, motorcycle.getTransmissionType());
    }

}