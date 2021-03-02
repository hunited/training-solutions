package covid;

import lombok.Data;

@Data
public class Citizen extends CitizenDao {

    private final String fullName;
    private final String zipCode;
    private final int age;
    private final String email;
    private final String ssn;

    public Citizen(String fullName, String zipCode, int age, String email, String ssn) {
        this.fullName = validateName(fullName);
        this.zipCode = validateZip(zipCode);
        this.age = validateAge(age);
        this.email = validateEmail(email);
        this.ssn = validateSSN(ssn);
    }

}
