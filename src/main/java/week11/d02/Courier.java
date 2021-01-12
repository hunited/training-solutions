package week11.d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private final List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        if (rides.isEmpty() && ride.getNumberOfRide() == 1) {
            rides.add(ride);
        } else if (rides.isEmpty() && ride.getNumberOfRide() != 1) {
            throw new IllegalArgumentException("Wrong Ride data");
        } else if ((ride.getDay() == rides.get(rides.size() - 1).getDay() &&
                ride.getNumberOfRide() == rides.get(rides.size() - 1).getNumberOfRide() + 1)
                || (ride.getDay() > rides.get(rides.size() - 1).getDay() && ride.getNumberOfRide() == 1)) {
            rides.add(ride);
        } else {
            throw new IllegalArgumentException("Wrong Ride data");
        }
    }

    public int firstOffDay() {
        boolean[] dayInWork = getDayInWork();
        for (int i = 0; i < dayInWork.length; i++) {
            if (!dayInWork[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    private boolean[] getDayInWork() {
        boolean[] dayInWork = new boolean[7];
        for (int i = 0; i < 7; i++) {
            for (Ride ride : rides) {
                if (ride.getDay() == i + 1) {
                    dayInWork[i] = true;
                    break;
                }
            }
        }
        return dayInWork;
    }

    public List<Ride> getRides() {
        return rides;
    }

}
