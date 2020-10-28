package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérlek add meg a kedvenc zeneszámod adatait!\nKezdjük a szerzővel:");
        song.band = scanner.nextLine();
        System.out.println("A zeneszám címe:");
        song.title = scanner.nextLine();
        System.out.println("Hány perces ez a zenemű?");
        song.length = scanner.nextInt();
        System.out.println(song.band+" - "+song.title+" ("+song.length+" perc)");
    }
}