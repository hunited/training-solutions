package week07.d02S;

public interface User {

    String getUsername();

    String getFirstName();

    String getLastName();

    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    static User of(String username, String firstName, String lastName) {
        return new UserImpl(username, firstName, lastName);
    }

}
