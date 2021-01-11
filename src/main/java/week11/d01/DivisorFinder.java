package week11.d01;

public class DivisorFinder {

    public int findDivisors(int n) {
        char[] temp = ("" + n).toCharArray();
        int result = 0;
        for (char c : temp) {
            int number;
            try {
                number = Integer.parseInt(String.valueOf(c));
            } catch (NumberFormatException nfe) {
                continue;
            }
            if (n % number == 0) {
                result++;
            }
        }
        return result;
    }

}
