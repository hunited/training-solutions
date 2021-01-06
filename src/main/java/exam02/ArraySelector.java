package exam02;

public class ArraySelector {

    public String selectEvens(int[] array) {
        StringBuilder result = new StringBuilder();
        if (array.length > 0) {
            result.append("[");
            for (int i = 0; i < array.length; i = i + 2) {
                result.append(array[i]).append(", ");
            }
            return result.replace(result.length() - 2, result.length(), "]").toString();
        }
        return result.toString();
    }

}
