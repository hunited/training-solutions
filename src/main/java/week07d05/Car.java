package week07d05;

public class Car extends Vehicle {

    public Car() {
        super(TransmissionType.AUTOMATIC);
    }

    public Car(int numberOfGears, TransmissionType transmissionType) {
        super(numberOfGears, transmissionType);
    }
}
