package virtualmethod.vehicle;

public class Vehicle {

    public static final int PERSON_AVERAGE_WEIGHT = 75;

    private int vehicleWeight;

    public Vehicle(int vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }

    public int getGrossLoad() {
        return vehicleWeight + PERSON_AVERAGE_WEIGHT;
    }

    public int getVehicleWeight() {
        return vehicleWeight;
    }

    public static int getPersonAverageWeight() {
        return PERSON_AVERAGE_WEIGHT;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleWeight=" + vehicleWeight +
                '}';
    }

}
