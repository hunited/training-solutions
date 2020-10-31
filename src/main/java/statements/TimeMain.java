package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg hány óra van:");
        int hourOne = scanner.nextInt();
        System.out.println("Add meg hány perc van:");
        int minOne = scanner.nextInt();
        System.out.println("Add meg hány másodperc van:");
        int secOne = scanner.nextInt();

        System.out.println("Add meg egy másik órát:");
        int hourTwo = scanner.nextInt();
        System.out.println("Add meg egy másik percet:");
        int minTwo = scanner.nextInt();
        System.out.println("Add meg egy másik másodpercet:");
        int secTwo = scanner.nextInt();

        Time timeOne = new Time(hourOne,minOne,secOne);
        Time timeTwo = new Time(hourTwo,minTwo,secTwo);

        System.out.println("Az első időpont " + timeOne.toString() + " = " + timeOne.getInMinutes() + " perc");
        System.out.println("A második időpont " + timeTwo.toString() + " = " + timeTwo.getInSeconds() + " másodperc");
        System.out.println("Az első korábbi, mint a második: " + timeOne.earlierThan(timeTwo));
    }
}
