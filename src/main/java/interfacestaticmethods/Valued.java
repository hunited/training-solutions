package interfacestaticmethods;

import java.util.List;

public interface Valued {

    double getValue();

    static double totalValue(List<Valued> values) {
        double d = 0;
        for (Valued value : values) {
            d += value.getValue();
        }
        return d;
    }

}
