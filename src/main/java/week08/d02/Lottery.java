package week08.d02;

import java.util.*;

public class Lottery {

    public List<Integer> winnersGenerator(int interval, int numbers) {
        List<Integer> winners = new ArrayList<>();
        Random random = new Random(10);
        int i = 1;
        while (winners.size() < numbers) {
            int number = random.nextInt(interval) + 1;
            if (!winners.contains(number)) {
                winners.add(number);
                System.out.println("Az " + i + ". nyerőszám: " + number);
                i++;
            }
        }
        Collections.sort(winners);
        return winners;
    }

    public static void main(String[] args) {
        List<Integer> winners = new Lottery().winnersGenerator(90, 5);
        System.out.print("A nyerőszámok növekvő sorrendben: ");
        System.out.print(winners.get(0));
        for (int i = 1; i < winners.size(); i++) {
            System.out.print(", " + winners.get(i));
        }
    }

}
