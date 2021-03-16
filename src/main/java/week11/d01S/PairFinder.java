package week11.d01S;

import java.util.Arrays;

public class PairFinder {

    public int findPairs(int[] arr) {
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                result++;
                i++;
            }
        }
        return result;
    }

}
