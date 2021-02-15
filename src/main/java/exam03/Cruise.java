package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private final Boat boat;
    private final LocalDate sailing;
    private final double basicPrice;
    private final List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.getMaxPassengers() > passengers.size()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("Passenger limit reached");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getMultiplier() * basicPrice;
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }
        throw new IllegalArgumentException("Passenger not found");
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> passengerNames = new ArrayList<>();
        for (Passenger passenger : passengers) {
            passengerNames.add(passenger.getName());
        }
        passengerNames.sort(Comparator.naturalOrder());
        return passengerNames;
    }

    public double sumAllBookingsCharged() {
        double result = 0.0;
        for (Passenger passenger : passengers) {
            result += getPriceForPassenger(passenger);
        }
        return result;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> result = new HashMap<>();
        for (Passenger passenger : passengers) {
            CruiseClass cc = passenger.getCruiseClass();
            if (!result.containsKey(cc)) {
                result.put(cc, 0);
            }
            result.replace(cc, result.get(cc) + 1);
        }
        return result;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

}
