package week11.d01;

public class DivisorFinder {

    public int findDivisors(int n) {
        char[] temp = ("" + n).toCharArray();
        int result = 0;
        for (char c : temp) {
            int number;
            if (c != '-') {
                number = Character.getNumericValue(c);
            } else {
                continue;
            }
            if (n % number == 0) {
                result++;
            }
        }
        return result;
    }

}
