package week02;

import java.util.Scanner;

public class Controller {

    private Office office;

    Scanner scanner = new Scanner(System.in);

    public void readOffice() {

        office = new Office();

        System.out.println("Hány tárgyalót szeretne létrehozni?");
        int db = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < db; i++) {
            System.out.println("Adja meg a(z) " + (i + 1) + ". tárgyaló nevét!");
            String name = scanner.nextLine();

            System.out.println("Adja meg a(z) " + (i + 1) + ". tárgyaló hosszúságát!");
            int length = Integer.parseInt(scanner.nextLine());

            System.out.println("Adja meg a(z) " + (i + 1) + ". tárgyaló szélességét!");
            int width = Integer.parseInt(scanner.nextLine());

            office.addMeetingRoom(new MeetingRoom(name, length, width));
        }

    }

    public void printMenu() {

        System.out.println("1. Tárgyalók sorrendben\n2. Tárgyalók visszafele sorrendben\n3. Minden második tárgyaló\n4. Területek\n5. Keresés pontos név alapján\n6. Keresés névtöredék alapján\n7. Keresés terület alapján\n");

    }

    public void runMenu() {

        System.out.println("Kérlek válassz menüpontot!");

        int selection;
        try {
            selection = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            selection = 0;
        }

        switch (selection) {
            case 1:
                office.printNames();
                break;
            case 2:
                office.printNamesReverse();
                break;
            case 3:
                office.printEventNames();
                break;
            case 4:
                office.printAreas();
                break;
            case 5:
                System.out.println("Add meg a keresendő tárgyaló nevét!");
                office.printMeetingRoomsWithName(scanner.nextLine());
                break;
            case 6:
                System.out.println("Add meg a keresendő kifejezést!");
                office.printMeetingRoomsContains(scanner.nextLine());
                break;
            case 7:
                System.out.println("A tárgyaló legyen nagyobb mint:");
                office.printAreasLargerThan(Integer.parseInt(scanner.nextLine()));
                break;
            default:
                System.out.println("Nincs ilyen menüpont!");
                break;
        }

    }

    public static void main(String[] args) {

        Controller controller = new Controller();

        controller.readOffice();
        controller.printMenu();
        controller.runMenu();
    }

}
