package virtualmethod.vehicle;

public class Van extends Car {

    private int cargoWeight;

    public Van(int numberPassenger, int vehicleWeight, int cargoWeight) {
        super(vehicleWeight, numberPassenger);
        this.cargoWeight = cargoWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + cargoWeight;
    }

    @Override
    public String toString() {
        return "Van{cargoWeight=" + cargoWeight + ", numberOfPassenger=" + getNumberPassenger() + ", vehicleWeight=" + getVehicleWeight() + '}';
    }

}
