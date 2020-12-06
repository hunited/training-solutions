package inheritanceconstructor.cars;

public class Jeep extends Car {

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (extraFuel > extraCapacity) {
            throw new IllegalArgumentException("Auxiliary capacity is less than extra fuel!");
        }
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public void modifyFuelAmount(double fuel) {
        double used = extraCapacity - extraFuel;
        if (extraCapacity - extraFuel >= fuel) {
            extraFuel += fuel;
        }
        if (super.getTankCapacity() - super.getFuel() < fuel - used) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        if (extraCapacity - extraFuel < fuel) {
            extraFuel += extraCapacity - extraFuel;
            fuel -= used;
            super.modifyFuelAmount(fuel);
        }
    }

    public void drive(int km) {
        if (km * getFuelRate() / 100 > getFuel() + extraFuel) {
            throw new RuntimeException("Not enough fuel available!");
        }
        extraFuel -= km * super.getFuelRate() / 100;
        if (extraFuel < 0) {
            super.modifyFuelAmount(extraFuel);
            extraFuel = 0;
        }
    }

    public double calculateRefillAmount() {
        return (getExtraCapacity() + super.getTankCapacity()) - (super.getFuel() + getExtraFuel());
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }
}
