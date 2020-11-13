package introexception.patient;

public class Patient {

    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {

        if (yearOfBirth <= 1900 ) {
            throw new IllegalArgumentException("Invalid year of birth: " + yearOfBirth);
        }

        if (name == null) {
            throw new IllegalArgumentException("Name must not be empty");
        }

        if (!new SsnValidator().isValidSsn(socialSecurityNumber)) {
            throw new IllegalArgumentException("Invalid Social Security Number: " + socialSecurityNumber);
        }

        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
