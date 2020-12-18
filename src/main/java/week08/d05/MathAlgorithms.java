package week08.d05;

public class MathAlgorithms {

    public int greatestCommonDivisor(int one, int two) {
        if (one < 1 || two < 1) {
            throw new IllegalArgumentException("Nem lehet nulla vagy nagatív.");
        }
        int div = 1;
        for (int i = 2; i <= one && i <= two; i++) {
            if (one % i == 0 && two % i == 0) {
                div = i;
            }
        }
        return div;
    }

}
