package controliteration.pi;

import java.util.Scanner;

public class PiGenerator {

    public String getPi() {
        String pi = "";
        String text = "Nem a régi s durva közelítés, " +
                "Mi szótól szóig így kijön " +
                "Betűiket számlálva. " +
                "Ludolph eredménye már, " +
                "Ha itt végezzük húsz jegyen. " +
                "De rendre kijő még tíz pontosan, " +
                "Azt is bízvást ígérhetem.";
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String temp = scanner.next();
            if (temp.length() == 1 && temp.contains("a")) {
                pi += ".";
            }
            if (temp.contains(".") || temp.contains(",")) {
                pi += (temp.length() - 1);
            } else {
                pi += temp.length();
            }
        }
        return pi;
    }

}
