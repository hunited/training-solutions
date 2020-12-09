package week07d01S;

public class Fibonacci {

    public static long fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Counter can't be less then 0");
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (RESULTS[n] == null) {
            RESULTS[n] = fib(n - 2) + fib(n - 1);
            System.out.println(RESULTS[n]);
        }
        return RESULTS[n];
    }

    private static final Long[] RESULTS = new Long[1024];

    public static void main(String[] args) {
        fib(100);
    }

}
