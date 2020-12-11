package week03d04;

import java.util.Scanner;

public class PhoneParser {

    public Phone parse(String s) {
        String prefix = s.substring(0, 2);
        String number = s.substring(3);

        Phone phone = new Phone(prefix, number);
        return phone;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String countryPrefix = "+36-";
        System.out.println("Add meg a telefonszámot a következő formátumban: 30-xxxxxxx");

        PhoneParser phoneParser = new PhoneParser();

        System.out.println("A megadott szám: " + countryPrefix + phoneParser.parse(scanner.nextLine().toString()));

    }

}
