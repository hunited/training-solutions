package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        MathOperations mathOperations = new MathOperations();

        double goodAnswer = (1 + 3) * 4 - (3 / 2D);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Old meg a következő feladatot: (1 + 3) x 4 - (3 : 2)");
        double answer = scanner.nextDouble();
        System.out.println((Math.abs(goodAnswer - answer) < 0.0001) ? "A megadott válasz helyes!" : "A megadott válasz helytelen! A helyes válasz: " + goodAnswer);

    }

}
