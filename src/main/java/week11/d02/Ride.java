package week11.d02;

public class Ride {

    private final int day;
    private final int numberOfRide;
    private final int distance;

    public Ride(int day, int numberOfRide, int distance) {
        this.day = day;
        this.numberOfRide = numberOfRide;
        this.distance = distance;
    }

    public int getDay() {
        return day;
    }

    public int getNumberOfRide() {
        return numberOfRide;
    }

    public int getDistance() {
        return distance;
    }

}
