package algorithmsmax.integers;

import java.util.List;

public class IntegerMaxCalculator {

    public int max(List<Integer> integers)  {
        int max = integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            max = integers.get(i) > max ? integers.get(i) : max;
        }
        return max;
    }

}
