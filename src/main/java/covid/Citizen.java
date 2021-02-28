package covid;

import lombok.Data;

@Data
public class Citizen {

    private final String fullName;
    private final String zipCode;
    private final int age;
    private final String email;
    private final String ssn;

    public Citizen(String fullName, String zipCode, int age, String email, String ssn) {
        CitizenDao dao = new CitizenDao();
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name most not be empty");
        }
        this.fullName = fullName.trim();
        if (zipCode == null || zipCode.trim().length() != 4 || dao.getSettlementsByZip(zipCode).isEmpty()) {
            throw new IllegalArgumentException("ZIP Code error: must be 4 characters or settlement not found in the database");
        }
        this.zipCode = zipCode.trim();
        if (age > 150 || age < 10) {
            throw new IllegalArgumentException("Age must be between 10 and 150");
        }
        this.age = age;
        if (email.trim().length() < 4 || !email.trim().contains("@")) {
            throw new IllegalArgumentException("Email format error");
        }
        this.email = email.trim();
        if (!dao.validSsn(ssn.trim())) {
            throw new IllegalArgumentException("SSN number is non valid");
        }
        this.ssn = ssn.trim();
    }

}
