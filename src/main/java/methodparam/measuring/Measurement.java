package methodparam.measuring;

import java.util.List;

public class Measurement {

    private double[] results;

    public Measurement(double[] results) {
        this.results = results;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0; i < results.length; i++) {
            if (lower < results[i] && results[i] < upper) {
                return i;
            }
        }
        return -1;
    }

    public double minimum() {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < results.length; i++) {
            if (results[i] < min) {
                min = results[i];
            }
        }
        return min;
    }

    public double maximum() {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < results.length; i++) {
            if (results[i] > max) {
                max = results[i];
            }
        }
        return max;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }

}
