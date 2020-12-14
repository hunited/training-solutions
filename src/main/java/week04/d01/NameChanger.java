package week04.d01;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullName) {

        if (fullName == null || "".equals(fullName.trim())) {
            throw new IllegalArgumentException("Invalid name: " + fullName);
        }
        this.fullName = fullName;
    }

    public String changeFirstName(String firstName) {
        int space = fullName.indexOf(" ");
        String originalFirstName = fullName.substring(0, space);
        String originalLastName = fullName.substring(space + 1);
        String fullName = firstName + " " + originalLastName;
        return fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
