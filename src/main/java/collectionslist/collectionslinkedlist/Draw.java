package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then " + maxNumber + "!");
        }
        return new TreeSet<>(createNumberPool(maxNumber));
    }

    private List<Integer> createNumberPool(int balls) {
        List<Integer> ballPool = new ArrayList<>();
        for (int i = 1; i <= balls; i++) {
            ballPool.add(i);
        }
        Collections.shuffle(ballPool);
        return ballPool;
    }

}
