package week02d04;

import java.util.Arrays;
import java.util.Scanner;

public class InputNames {
    public static void main(String[] args) {

        String[] name = new String[5];

        Scanner scanner = new Scanner(System.in);

        for (var i = 0; i < name.length; i++) {
            System.out.println("Add meg a(z) " + (i + 1) + ". nevet!");
            name[i] = scanner.nextLine();
        }

        int i = 0;
        for (String names : name) {
            i++;
            System.out.println(i + ". név: " + names);
        }

        System.out.println(Arrays.toString(name));

    }
}
