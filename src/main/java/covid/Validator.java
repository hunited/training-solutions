package covid;

public class Validator {

    private final CitizenDao dao = new CitizenDao();

    public String validateName(String fullname) {
        if (fullname == null || fullname.trim().isEmpty()) {
            throw new IllegalArgumentException("A név nem lehet üres!");
        }
        return fullname.trim();
    }

    public String validateZip(String zipCode) {
        if (zipCode == null || zipCode.trim().length() != 4 || dao.getSettlementsByZip(zipCode).isEmpty()) {
            throw new IllegalArgumentException("Irányítószám hiba: csak 4 karakter lehet, vagy nem található meg az adatbázisban!");
        }
        return zipCode.trim();
    }

    public int validateAge(int age) {
        if (age > 150 || age < 10) {
            throw new IllegalArgumentException("Az életkor csak 10 és 150 között lehet!");
        }
        return age;
    }

    public String validateEmail(String email) {
        if (email.trim().length() < 3 || !email.trim().contains("@")) {
            throw new IllegalArgumentException("E-mail formátum hiba: minimum 3 karakter és @ jel kötelező!");
        }
        return email.trim();
    }

    public String validateSSN(String ssn) {
        if (!validSsn(ssn.trim())) {
            throw new IllegalArgumentException("Nem érvényes a TAJ szám!");
        }
        return ssn.trim();
    }

    public boolean validSsn(String ssn) {
        if (ssn.length() != 9) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < ssn.length() - 1; i++) {
            int num = Character.getNumericValue(ssn.charAt(i));
            sum += i % 2 == 0 ? num * 3 : num * 7;
        }
        int cNumber = Character.getNumericValue(ssn.charAt(ssn.length() - 1));
        return sum % 10 == cNumber;
    }

}
