package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérlek adj meg egy számot!");
        int elso = scanner.nextInt();
        System.out.println("Kérlek adj meg még egy számot!");
        int masodik = scanner.nextInt();
        System.out.println(elso+" + "+masodik);
        System.out.println(elso+masodik);
    }
}
