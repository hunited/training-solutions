package introcontrol;

import java.util.Scanner;

import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Felhasználók listázása\n2. Felhasználó felvétele\nTöbbi: Kilépés");
        int number = Integer.parseInt(scanner.nextLine());

        if (number == 1) {
            System.out.println("Felhasználók listázása");
        } else if (number == 2) {
            System.out.println("Felhasználó felvétele");
        }

    }
}
