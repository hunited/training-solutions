package covid;

import java.util.Scanner;

import static java.lang.System.*;

public class CovidMain extends CitizenDao {

    private static final Scanner scanner = new Scanner(in);

    public void runMenu() {
        printMenu();
        int selection;
        try {
            selection = Integer.parseInt(scanner.nextLine());
            if (selection == 1) {
                registerCitizen();
            } else if (selection == 2) {
                registerCitizensByCsv();
            } else if (selection == 3) {
                generateListByZip();
            } else if (selection == 4) {
                registerCitizen();
            } else if (selection == 5) {
                registerCitizen();
            } else if (selection == 6) {
                registerCitizen();
            } else if (selection == 7) {
                out.println("Viszont látásra!");
                return;
            } else {
                out.println("Hibás menüválasztás. Próbálja újra.");
            }
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
        }
        runMenu();
    }

    public static void main(String[] args) {
        CovidMain cm = new CovidMain();
        cm.runMenu();
    }

    private void printMenu() {
        out.println(
                """
                        Covid oltási nyilvántartás
                        Kérem válasszon menüpontot!
                        1. Regisztráció
                        2. Tömeges regisztráció
                        3. Generálás
                        4. Oltás
                        5. Oltás meghiúsulás
                        6. Riport
                        7. Kilépés"""
        );
    }

    private void registerCitizen() {
        out.println("Covid oltás regisztráció");
        Citizen citizen = new Citizen(getName(), getZip(), getAge(), getEmail(), getSsn());
        try {
            uploadCitizenToDb(citizen);
            out.println("Paciens sikeresen hozzáadva az adatbázishoz!");
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
        }
    }

    private void registerCitizensByCsv() {
        out.println("Covid oltás kötegelt regisztráció");
        out.println("Kérem adja meg a fájlnevet!");
        try {
            out.println(uploadCitizensFromFile(scanner.nextLine()));
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
        }
    }

    private void generateListByZip() {
        out.println("Irányítószámos lista generálása fájlba");
        try {
            out.println("Kérem adja meg az irányítószámot");
            String zip = hasZipInCitizens(scanner.nextLine());
            out.println("Kérem adja meg a fájlnevet!");
            String fileName = scanner.nextLine();
            saveListToFile(zip, fileName);
            out.println("A fáljl elmentve az src/main/resources/covid/" + fileName + " fájlba!");
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            generateListByZip();
        }
    }

    private String getName() {
        out.println("Kérem adja meg a paciens nevét!");
        try {
            return validateName(scanner.nextLine());
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getName();
        }
    }

    private String getZip() {
        out.println("Kérem adja meg a paciens irányítószámát!");
        try {
            return validateZip(scanner.nextLine());
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getZip();
        }
    }

    private int getAge() {
        out.println("Kérem adja meg a paciens életkorát!");
        try {
            return validateAge(Integer.parseInt(scanner.nextLine()));
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getAge();
        }
    }

    private String getEmail() {
        out.println("Kérem adja meg a paciens e-mail címét!");
        try {
            String email = validateEmail(scanner.nextLine());
            return reCheckEmail(email);

        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getEmail();
        }
    }

    private String reCheckEmail(String email) {
        out.println("Kérem ismételje meg!");
        String check = scanner.nextLine();
        if (email.equals(check)) {
            return email;
        } else {
            out.println("Nem egyező e-mail cím! Adja meg újra!");
            return getEmail();
        }
    }

    private String getSsn() {
        out.println("Kérem adja meg a paciens TB számát!");
        try {
            return validateSSN(scanner.nextLine());
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getSsn();
        }
    }

    private void throwIAE(IllegalArgumentException iae) {
        out.println("Hiba történt, próbálja újra: " + iae.getMessage());
    }

}
