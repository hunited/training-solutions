package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérlek adj meg egy egészszámot!");
        int number = scanner.nextInt();

        String divThree = number % 3 == 0 ? "" : "nem ";

        System.out.println("Ez a szám " +divThree+ "osztható hárommal");
    }
}
