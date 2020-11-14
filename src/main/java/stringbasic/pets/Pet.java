package stringbasic.pets;

import introjunit.Gentleman;

import java.time.LocalDate;

public class Pet {

    private String name;

    private LocalDate birth;

    private Gender gender;

    private String regId;

    public Pet(String name, LocalDate birth, Gender gender, String regId) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.regId = regId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegId() {
        return regId;
    }

}
