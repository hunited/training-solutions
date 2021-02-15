package week16.d01;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CanoeOffice {

    private final List<CanoeRental> rentals = new ArrayList<>();

    private static final int PRICE_PER_HOUR = 5000;

    public void addRental(CanoeRental canoeRental) {
        rentals.add(canoeRental);
    }

    public CanoeRental findRentalByName(String name) {
        for (CanoeRental canoeRental : rentals) {
            if (canoeRental.getName().equals(name) && canoeRental.getEndTime() == null) {
                return canoeRental;
            }
        }
        throw new IllegalArgumentException("No opened rental by this name");
    }

    public void closeRentalByName(String name, LocalDateTime endTime) {
        findRentalByName(name).setEndTime(endTime);
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        CanoeRental cr = findRentalByName(name);
        double result = ChronoUnit.MINUTES.between(cr.getStartTime(), endTime);
        return Math.ceil(result / 60) * cr.getCanoeType().getValue() * PRICE_PER_HOUR;
    }

    public List<CanoeRental> listClosedRentals() {
        List<CanoeRental> result = new ArrayList<>();
        for (CanoeRental canoeRental : rentals) {
            if (canoeRental.getEndTime() != null) {
                result.add(canoeRental);
            }
        }
        result.sort(Comparator.comparing(CanoeRental::getEndTime));
        if (!result.isEmpty()) {
            return result;
        }
        throw new IllegalArgumentException("Closed rental not found");
    }

    public Map<CanoeType, Integer> countRentals() {
        Map<CanoeType, Integer> result = new HashMap<>();
        for (CanoeRental canoeRental : rentals) {
            if (!result.containsKey(canoeRental.getCanoeType())) {
                result.put(canoeRental.getCanoeType(), 0);
            }
            result.replace(canoeRental.getCanoeType(), result.get(canoeRental.getCanoeType()) + 1);
        }
        return result;
    }

    public List<CanoeRental> getRentals() {
        return rentals;
    }

}
