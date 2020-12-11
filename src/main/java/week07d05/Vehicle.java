package week07d05;

public class Vehicle {

    private int numberOfGears = 5;
    private TransmissionType transmissionType = TransmissionType.MANUAL;

    public Vehicle(int numberOfGears, TransmissionType transmissionType) {
        this.numberOfGears = numberOfGears;
        this.transmissionType = transmissionType;
    }

    public Vehicle() {
        numberOfGears = 5;
        transmissionType = TransmissionType.MANUAL;
    }

    public Vehicle(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }
}
