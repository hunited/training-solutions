package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("binaryString null");
        }
        boolean[] out = new boolean[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                out[i] = false;
            } else if (str.charAt(i) == '1') {
                out[i] = true;
            } else {
                throw new IllegalArgumentException("binaryString not valid");
            }
        }
        return out;
    }

    public String booleanArrayToBinaryString(boolean[] booleans) {
        if (booleans == null || booleans.length == 0) {
            throw new IllegalArgumentException("A tömb nem megfelelő");
        }
        String out = "";
        for (int i = 0; i < booleans.length; i++) {
            out += booleans[i] ? 1 : 0;
        }
        return out;
    }

}
