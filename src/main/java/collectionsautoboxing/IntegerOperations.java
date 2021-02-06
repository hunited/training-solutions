package collectionsautoboxing;

import java.util.ArrayList;
import java.util.List;

public class IntegerOperations {
    public List<Integer> createList(int... numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i : numbers) {
            result.add(i);
        }
        return result;
    }

    public int sumIntegerList(List<Integer> integerList) {
        int sum = 0;
        for (int i : integerList) {
            sum += i;
        }
        return sum;
    }

    public int sumIntegerObjects(int... integers) {
        return sumIntegerList(createList(integers));
    }

}
