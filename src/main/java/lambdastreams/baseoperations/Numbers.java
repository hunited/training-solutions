package lambdastreams.baseoperations;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Integer> integers;

    public Numbers(List<Integer> integers) {
        this.integers = integers;
    }

    public Optional<Integer> min() {
        return getIntegers().stream().min(Comparator.naturalOrder());
    }

    public int sum() {
        return getIntegers().stream().reduce(0, Integer::sum);
    }

    public Collection<Object> getDistinctElements() {
        return getIntegers().stream().collect(Collectors.toSet());
    }

    public boolean isAllPositive() {
        return getIntegers().stream().allMatch(i -> i > 0);
    }

    public List<Integer> getIntegers() {
        return new ArrayList<>(integers);
    }

}
