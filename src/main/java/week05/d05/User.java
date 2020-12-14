package week05.d05;

public class User {

    private String firstName;

    private String lastName;

    private String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Az e-mail cím formátuma hibás!");
        }
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFulltName() {
        return getFirstName() + " " + getLastName();
    }

}
