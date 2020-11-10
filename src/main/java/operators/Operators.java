package operators;

public class Operators {

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public int multiplyByPowerOfTwo(int doubler, int times) {
        return doubler << times;
    }

}
