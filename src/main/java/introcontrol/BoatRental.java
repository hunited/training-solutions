package introcontrol;

import java.util.Scanner;

public class BoatRental {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("A csapat létszáma?");
        int teamSize = Integer.parseInt(scanner.nextLine());

        String text = "A csapat létszáma: " + teamSize + " ";

        if (teamSize == 0 ) {
            System.out.println(text + "Nem vittek el egy csónakot sem. Utánuk mehet: 10 fő");
        } else if (teamSize > 10) {
            System.out.println(text + "Maradtak még a parton!");
        } else if (teamSize <= 2 ) {
            System.out.println(text + "Elvitték a 2 személyes csónakot. Utánuk mehet: 8 fő");
        } else if (teamSize <= 3 ) {
            System.out.println(text + "Elvitték a 3 személyes csónakot. Utánuk mehet: 7 fő");
        } else if (teamSize <= 5 ) {
            System.out.println(text + "Elvitték az 5 személyes csónakot. Utánuk mehet: 5 fő");
        } else if (teamSize <= 7 ) {
            System.out.println(text + "Elvitték az 5 és 2 személyes csónakot. Utánuk mehet: 3 fő");
        } else if (teamSize <= 8 ) {
            System.out.println(text + "Elvitték az 5 és 3 személyes csónakot. Utánuk mehet: 2 fő");
        } else if (teamSize <= 10 ) {
            System.out.println(text + "Elvitték az összes csónakot. Utánuk mehet: 0 fő");
        }

    }
}
