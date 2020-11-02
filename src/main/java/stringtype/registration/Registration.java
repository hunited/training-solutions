package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg a felhasználói neved!");
        String username = scanner.nextLine();
        System.out.println("Add meg a jelszavad!");
        String password1 = scanner.nextLine();
        System.out.println("Erősítsd meg a jelszavad!");
        String password2 = scanner.nextLine();
        System.out.println("Add meg az e-mail címed!");
        String email = scanner.nextLine();

        UserValidator userValidator = new UserValidator();

        System.out.println(
                userValidator.isValidUsername(username) ?
                        "A megadott név " + username + ", a formátuma helyes!"
                        :
                        "A megadott név formátuma helytelen!"
        );

        System.out.println(
                userValidator.isValidPassword(password1,password2) ?
                        "A megadott jelszó formátuma helyes!"
                        :
                        "A megadott jelszó formátuma helytelen!"
        );

        System.out.println(
                userValidator.isValidEmail(email) ?
                        "A megadott email cím " + email + ", a formátuma helyes!"
                        :
                        "A megadott email cím formátuma helytelen!"
        );
    }
}
