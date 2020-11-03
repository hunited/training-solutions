package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {

        System.out.println("Kérlek adj meg egymás után 5 számot!");

        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        for (int i = 0; i < 5; i = i++) {
            System.out.print((i + 1) + ". szám: ");
            int number = scanner.nextInt();
            sum += number;
            i++;
        }

        System.out.println("Végösszeg: " + sum);

    }
}
