package schoolrecords;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SchoolRecordsController {

    public static ClassRecords classRecords = new ClassRecords("Fourth Grade A", new Random(5));

    public static Scanner scanner = new Scanner(System.in);

    private Tutor tutor;

    private Subject subject;

    public void initSchool() {
        Tutor tutor1 = new Tutor("Nagy Csilla", Arrays.asList(new Subject("matematika"), new Subject("fizika")));
        Tutor tutor2 = new Tutor("Gipsz Jakab", Arrays.asList(new Subject("andul"), new Subject("német")));
        Tutor tutor3 = new Tutor("Teszt Elek", Arrays.asList(new Subject("nyelvtan"), new Subject("irodalom")));
        Tutor tutor4 = new Tutor("Min Tamás", Arrays.asList(new Subject("kémia"), new Subject("testnevelés")));
    }

    public static void startMenu() {
        System.out.println(
                classRecords.getClassName() + " osztálynapló. Kérem válasszon funkciót:\n" +
                        "1. Diákok nevének listázása\n" +
                        "2. Diák név alapján keresése\n" +
                        "3. Diák létrehozása\n" +
                        "4. Diák név alapján törlése\n" +
                        "5. Diák feleltetése\n" +
                        "6. Osztályátlag kiszámolása\n" +
                        "7. Tantárgyi átlag kiszámolása\n" +
                        "8. Diákok átlagának megjelenítése\n" +
                        "9. Diák átlagának kiírása\n" +
                        "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                        "11. Kilépés"
        );
    }

    public static void runMenu() {
        startMenu();
        int selection;
        try {
            selection = Integer.parseInt(scanner.nextLine());
            if (selection == 1) {
                System.out.println(classRecords.listStudentNames());
                runMenu();
            } else if (selection == 2) {
                System.out.println("Kérem adja meg a keresett diák nevét:");
                try {
                    System.out.println(classRecords.findStudentByName(scanner.nextLine()));
                    runMenu();
                } catch (Exception e) {
                    System.out.println("Nincs ilyen nevű gyermek. Újra próbálja? 1: igen, más szám: vissza a menübe.");
                    int tryAgain = Integer.parseInt(scanner.nextLine());
                    if (tryAgain == 1) {
                        System.out.println("Keresendő név:");
                        System.out.println(classRecords.findStudentByName(scanner.nextLine()));
                        runMenu();
                    } else {
                        runMenu();
                    }
                }
            } else if (selection == 3) {
                System.out.println("Adja meg az új diák nevét!");
                try {
                    classRecords.addStudent(new Student(scanner.nextLine()));
                } catch (IllegalArgumentException iae) {
                    System.out.println("Hiba történt. Próbálja újra. " + iae.getMessage());
                }
                runMenu();
            } else if (selection == 4) {
                runMenu();
            } else if (selection == 5) {
                runMenu();
            } else if (selection == 6) {
                runMenu();
            } else if (selection == 7) {
                runMenu();
            } else if (selection == 8) {
                runMenu();
            } else if (selection == 9) {
                runMenu();
            } else if (selection == 10) {
                runMenu();
            } else if (selection == 11) {
                System.out.println("Viszont látásra!");
                return;
            } else {
                System.out.println("Hibás menüválasztás. Próbálja újra.");
                runMenu();
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("Hiba történt. Próbálja újra. " + iae.getMessage());
            runMenu();
        }
    }

    public static void main(String[] args) {
        runMenu();
    }

}
