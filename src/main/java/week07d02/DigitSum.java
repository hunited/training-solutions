package week07d02;

public class DigitSum {

    public int sumOfDigits(int x) {
        String temp = "" + x;
        int sum = 0;
        for (int i = 0; i < temp.length(); i++) {
            sum += Character.getNumericValue(temp.charAt(i));
        }
        return sum;
    }

}
