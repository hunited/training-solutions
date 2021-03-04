package covid;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.*;

public class CovidMain {

    private final Scanner scanner = new Scanner(in);
    private final CitizenDao dao = new CitizenDao();
    private final CovidFileManager cfm = new CovidFileManager();
    private final Validator validator = new Validator();

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
                vaccinationSuccessful();
            } else if (selection == 5) {
                vaccinationFailure();
            } else if (selection == 6) {
                report();
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
        out.println("""
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
            dao.uploadCitizenToDb(citizen);
            out.println("Paciens sikeresen hozzáadva az adatbázishoz!");
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
        }
    }

    private void registerCitizensByCsv() {
        out.println("Covid oltás kötegelt regisztráció");
        out.println("Kérem adja meg a fájlnevet!");
        try {
            out.println(cfm.uploadCitizensFromFile(scanner.nextLine()));
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
        }
    }

    private void generateListByZip() {
        out.println("Irányítószámos lista generálása fájlba");
        try {
            out.println("Kérem adja meg az irányítószámot");
            String zip = dao.hasZipInCitizens(scanner.nextLine());
            out.println("Kérem adja meg a fájlnevet!");
            String fileName = scanner.nextLine();
            cfm.saveListToFile(zip, fileName);
            out.println("A fáljl elmentve az src/main/resources/covid/" + fileName + " fájlba!");
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            generateListByZip();
        }
    }

    private void vaccinationSuccessful() {
        out.println("Oltás beadásának könyvelése");
        try {
            int citizenId = askTaj();
            dao.successfulVaccination(citizenId, getDate(), getVaccinationType(citizenId));
            out.println("Vakcina sikeresen könyvelve!");
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            vaccinationSuccessful();
        }
    }

    private void vaccinationFailure() {
        out.println("Oltás meghiúsulásának könyvelése");
        try {
            dao.unsuccessfulVaccination(askTaj(), getDate(), getNote());
            out.println("Meghiúsulás könyvelve!");
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            vaccinationFailure();
        }
    }

    private void report() {
        StringBuilder result = new StringBuilder();
        for (String zip : dao.queryZipCodes()) {
            result.append("Az ");
            result.append(zip);
            result.append(" irányítószámú települése(ke)n ");
            result.append(getReportData(zip));
            result.replace(result.length() - 2, result.length(), ".\n");
        }
        out.println(result.toString());
    }

    private StringBuilder getReportData(String zip) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Integer> datas = dao.queryNumberOfVaccinations(zip);
        for (Map.Entry<Integer, Integer> data : datas.entrySet()) {
            result.append(data.getKey());
            result.append(" oltást kapott paciens: ");
            result.append(data.getValue());
            result.append(" fő, ");
        }
        return result;
    }

    private String getName() {
        out.println("Kérem adja meg a paciens nevét!");
        try {
            return validator.validateName(scanner.nextLine());
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getName();
        }
    }

    private String getZip() {
        out.println("Kérem adja meg a paciens irányítószámát!");
        try {
            return validator.validateZip(scanner.nextLine());
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getZip();
        }
    }

    private int getAge() {
        out.println("Kérem adja meg a paciens életkorát!");
        try {
            return validator.validateAge(Integer.parseInt(scanner.nextLine()));
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getAge();
        }
    }

    private String getEmail() {
        out.println("Kérem adja meg a paciens e-mail címét!");
        try {
            String email = validator.validateEmail(scanner.nextLine());
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
            return validator.validateSSN(scanner.nextLine());
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getSsn();
        }
    }

    private LocalDateTime getDate() {
        out.println("Dátum megadása: mai nap: 1, saját időpont megadása: 2");
        int dayChoice = Integer.parseInt(scanner.nextLine());
        if (dayChoice == 1) {
            return LocalDateTime.now();
        } else if (dayChoice == 2) {
            return parseDate();
        } else {
            out.println("Hibás választás, próbálja újra!");
            return getDate();
        }
    }

    private LocalDateTime parseDate() {
        out.println("Adja meg a dátumot az alábbi formátumban: ÉÉÉÉ-HH-NN ÓÓ:PP");
        try {
            return LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (DateTimeParseException dtpe) {
            out.println("Hibás formátum, próbálja újra!");
            return parseDate();
        }
    }

    private Integer askTaj() {
        out.println("Kérem adja meg a paciens TAJ számát!");
        return dao.hasSuitableTajInCitizens(
                validator.validateSSN(scanner.nextLine())
        );
    }

    private VaccinationType getVaccinationType(int citizenId) {
        VaccinationType type = dao.firstVaccinationType(citizenId);
        if (dao.firstVaccinationType(citizenId) != null) {
            out.println("A paciens korábban " + type + " oltással volt oltva, most is csak ez adható!");
            return type;
        } else {
            out.println("Adja meg a beadott vakcina típusát!");
            int counter = 1;
            for (VaccinationType vaccinationType : VaccinationType.values()) {
                out.println(counter + ". gomb: " + vaccinationType + ".");
                counter++;
            }
            int typeChoice = Integer.parseInt(scanner.nextLine());
            if (typeChoice < 1 || typeChoice > VaccinationType.values().length) {
                out.println("Nem érvényes vakcina típus! Próbálja újra!");
                return getVaccinationType(citizenId);
            }
            int counter2 = 0;
            for (VaccinationType vaccinationType : VaccinationType.values()) {
                if (counter2 + 1 == typeChoice) {
                    return vaccinationType;
                }
                counter2++;
            }
        }
        throw new IllegalStateException("Valami hiba történt. Próbálja újra!");
    }

    private String getNote() {
        out.println("Kérem adja meg a meghiúsulás okát (max. 200 karakter)!");
        String result = scanner.nextLine();
        if (result.length() > 200) {
            out.println("Túl hosszú a szöveg, maximum 200 karakter lehet!");
            return getNote();
        }
        return result;
    }

    private void throwIAE(IllegalArgumentException iae) {
        out.println("Hiba történt, próbálja újra: " + iae.getMessage());
    }

}
