package collectionslist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Random;

public class Lottery {
    /* Gyors megoldás
    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        Random random = new Random();
        List<Integer> winners = new ArrayList<>(lotteryType);
        while (winners.size() < lotteryType) {
            int number = random.nextInt(ballCount) + 1;
            if (!winners.contains(number)) {
                winners.add(number);
            }
        }
        Collections.sort(winners);
        System.out.println(winners);
        return winners;
    }*/

    /* Tanári megoldás */
    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (ballCount <= lotteryType) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        List<Integer> ballPool = createBallPool(ballCount);
        List<Integer> winningNumbers = ballPool.subList(0, lotteryType);
        Collections.sort(winningNumbers);
        return winningNumbers;
    }

    private List<Integer> createBallPool(int balls) {
        List<Integer> ballPool = new ArrayList<>();
        for (int i = 1; i <= balls; i++) {
            ballPool.add(i);
        }
        Collections.shuffle(ballPool);
        return ballPool;
    }

}
