package week12.d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberStat {

    public int numberFinder(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Legalább 1 elemű lista kell.");
        }
        List<Integer> orderedNumbers = new ArrayList<>(numbers);
        Collections.sort(orderedNumbers);
        int result = orderedNumbers.get(0);
        int smalest = counter(orderedNumbers.get(0), orderedNumbers);
        int current = smalest;
        for (int i = 1; i < orderedNumbers.size(); i++) {
            if (!orderedNumbers.get(i).equals(orderedNumbers.get(i - 1))) {
                current = counter(orderedNumbers.get(i), orderedNumbers);
            }
            result = current < smalest ? orderedNumbers.get(i) : result;
        }
        return result;
    }

    private int counter(int number, List<Integer> numbers) {
        int counter = 0;
        for (int num : numbers) {
            if (number == num) {
                counter++;
            }
        }
        return counter;
    }

}
