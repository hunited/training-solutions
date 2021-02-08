package week15.d01;

import java.util.Map;

public class Coordinates {

    public Map.Entry<Double, Double> maxFinder(Map<Double, Double> coordinates) {
        if (coordinates.isEmpty() || coordinates.containsValue(Double.MIN_VALUE)) {
            throw new IllegalArgumentException("Wrong param");
        }
        Map.Entry<Double, Double> result = null;
        for (Map.Entry<Double, Double> entry : coordinates.entrySet()) {
            if (result == null || result.getValue() < entry.getValue()) {
                result = entry;
            }
        }
        return result;
    }

}
