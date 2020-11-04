package array;

public class ArrayHandler {

    public boolean contains(int[] source, int itemToFind) {
        for (int item : source) {
            if (item == itemToFind) {
                return true;
            }
        }
        return false;
    }

    public int find(int[] source, int itemToFind) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == itemToFind) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        ArrayHandler arrayHandler = new ArrayHandler();

        final int[] testArray = new int[]{1, 3, 5, 10};

        System.out.println(
                "Tartalmazza a következő értékeket?\n8: "
                        + arrayHandler.contains(testArray, 8)
                        + "\n5: "
                        + arrayHandler.contains(testArray, 5)
        );

        System.out.println(
                "Hányadik pozícióban van az alább érték?\n8: "
                        + arrayHandler.find(testArray, 8)
                        + "\n5: "
                        + arrayHandler.find(testArray, 5)
        );

    }
}
