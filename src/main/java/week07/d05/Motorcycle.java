package week07.d05;

public class Motorcycle extends Vehicle {

    public Motorcycle() {
        super(TransmissionType.SEQUENTIAL);
    }

    public Motorcycle(int numberOfGears, TransmissionType transmissionType) {
        super(numberOfGears, transmissionType);
    }
}
