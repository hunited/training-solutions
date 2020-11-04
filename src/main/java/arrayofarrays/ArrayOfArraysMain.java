package arrayofarrays;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size) {

        int[][] a = new  int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = (i + 1) * (j + 1);
            }
        }
        return a;
    }

    public void printArrayOfArrays(int[][] a) {
        for (int i[] : a) {
            for (int j : i) {
                if (j < 10) {
                    System.out.print("  ");
                } else if (j < 100) {
                    System.out.print(" ");
                }
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int[][] triangularMatrix(int size) {

        int[][] a = new  int[size][];

        for (int i = 0; i < a.length; i++) {
            a[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                a[i][j] = i;
            }
        }
        return a;
    }

    public int[][] getValues() {
        int[][] values = new int[12][];
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < numberOfDays.length; i++) {
            values[i] = new int[numberOfDays[i]];
        }
        return values;
    }

    public static void main(String[] args) {

        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        System.out.println("Szorzótábla");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.multiplicationTable(10));

        System.out.println("Mátrix");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.triangularMatrix(10));

        System.out.println("A hónap napjai");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.getValues());
    }
}
