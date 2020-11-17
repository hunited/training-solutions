package recursion;

public class FactorialCalculator {

    public long getFactorial(int number) {
        if (number > 1) {
            long factorial = getFactorial(number - 1);
            return factorial * number;
        } else {
            return 1;
        }
    }

}
