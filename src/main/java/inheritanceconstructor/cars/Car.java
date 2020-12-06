package inheritanceconstructor.cars;

public class Car {

    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        if (tankCapacity < fuel) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.tankCapacity = tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel += fuel;
    }

    public void drive(int km) {
        if (km * fuelRate / 100 > fuel) {
            throw new RuntimeException("Not enough fuel available!");
        }
        fuel -= km * fuelRate / 100;
    }

    public double calculateRefillAmount() {
        return getTankCapacity() - getFuel();
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

}
