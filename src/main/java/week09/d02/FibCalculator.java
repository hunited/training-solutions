package week09.d02;

public class FibCalculator {

    public long sumEvens(int bound) {
        if (bound < 2) {
            throw new IllegalArgumentException("A bemeneti érték nem lehet kettőnél kisebb!");
        }
        long sumOfEvenFibs = 0;
        long a = 0;
        long b = 1;
        long c;
        while (b + a <= bound) {
            c = a + b;
            if (c % 2 == 0) {
                sumOfEvenFibs += c;
            }
            a = b;
            b = c;
        }
        return sumOfEvenFibs;
    }

}
