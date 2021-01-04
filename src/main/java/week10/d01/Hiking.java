package week10.d01;

import java.util.List;

public class Hiking {

    public double getPlusElevation(List<Position> elevations) {
        if (elevations == null || elevations.isEmpty()) {
            throw new NullPointerException("A lista nem lehet üres");
        } else if (elevations.size() == 1) {
            throw new IllegalArgumentException("A lista legalább két elemű legyen");
        }
        double sum = 0.0;
        for (int i = 1; i < elevations.size(); i++) {
            if (elevations.get(i).getPosZ() > elevations.get(i - 1).getPosZ()) {
                sum += elevations.get(i).getPosZ() - elevations.get(i - 1).getPosZ();
            }
        }
        return sum;
    }

}
