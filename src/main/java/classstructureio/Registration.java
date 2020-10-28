package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérlek add meg a neved!");
        String name = scanner.nextLine();
        System.out.println("Kérlek add meg az e-mail címed!");
        String email = scanner.nextLine();
        System.out.println("Sikeresen regisztráltál a következő adatokkal:\nNév: "+name+"\nE-mail cím: "+email);
    }
}
