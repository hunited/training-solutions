package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    public String numberOfDaysAsString() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    public List<String> daysOfWeek() {
        return Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");
    }

    public String multiplicationTableAsString(int size) {
        int[][] a = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = (i + 1) * (j + 1);
            }
        }
        return Arrays.deepToString(a);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    public boolean wonLottery(int[] winner, int[] myNumbers) {
        Arrays.sort(winner);
        Arrays.sort(myNumbers);
        return Arrays.equals(myNumbers, winner);
    }

    public static void main(String[] args) {

        ArraysMain arraysMain = new ArraysMain();

        System.out.println(arraysMain.numberOfDaysAsString());

        System.out.println(arraysMain.daysOfWeek());

        System.out.println(arraysMain.multiplicationTableAsString(5));

        System.out.println(arraysMain.sameTempValues(new double[]{1, 2, 3}, new double[]{1, 2, 3}));
        System.out.println(arraysMain.sameTempValues(new double[]{1, 2, 3}, new double[]{4, 5, 6}));

        int[] winner = new int[]{1, 2, 3, 4, 5};
        int[] myNumbers = new int[]{5, 4, 1, 3, 2};
        System.out.println("Nyert e: " + arraysMain.wonLottery(winner, myNumbers));

        String winNumbers = Arrays.toString(winner);
        System.out.println(winNumbers);
        String myNumbersS = Arrays.toString(myNumbers);
        System.out.println(myNumbersS);

    }
}
