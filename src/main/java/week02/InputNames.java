package week02;

import java.util.Scanner;

public class InputNames {
    public static void main(String[] args) {

        String[] name = new String[5];

        Scanner scanner = new Scanner(System.in);

        for (var i = 0; i < name.length; i++) {
            System.out.println("Add meg a(z) " + (i + 1) + ". nevet!");
            name[i] = scanner.nextLine();
        }

        for (String names : name) {
            System.out.println(names);
        }

    }
}
