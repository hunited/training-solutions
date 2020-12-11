package week07d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void testCar() {
        Car car = new Car();
        assertEquals(5, car.getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, car.getTransmissionType());
    }

    @Test
    public void testCar2() {
        Car car = new Car(4, TransmissionType.MANUAL);
        assertEquals(4, car.getNumberOfGears());
        assertEquals(TransmissionType.MANUAL, car.getTransmissionType());
    }

}