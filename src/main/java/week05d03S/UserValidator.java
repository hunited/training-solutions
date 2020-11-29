package week05d03S;

import java.util.Arrays;
import java.util.List;

public class UserValidator {

    public void error(String iaeMessage) {
        throw new IllegalArgumentException(iaeMessage);
    }

    public String validate(List<User> users) {

        String iaeMessage;
        String userData = "";
        for (User user : users) {

            if (user.getAge() < 0) {
                iaeMessage = "Hibás adat: a felhasználó életkora 0-nál kisebb!";
                error(iaeMessage);
            } else if (user.getAge() > 120) {
                iaeMessage = "Hibás adat: a felhasználó életkora 120-nál több!";
                error(iaeMessage);
            } else if (user.getName() == null || "".equals(user.getName())) {
                iaeMessage = "Hibás adat: a felhasználó neve üres!";
                error(iaeMessage);
            } else {
                userData = user.toString();
            }
        }
        String text = "Minden rendben volt, a felhasználó (" + userData + ") adatai megfelelőek!";
        return text;

    }

    /*public static void main(String[] args) {
        UserValidator uv = new UserValidator();
        System.out.println(uv.validate(Arrays.asList(
                new User("Gasparics Sándor", 40),
                new User("Gasparics Sándor", -5),
                new User("Gasparics Sándor", 121),
                new User("", 40),
                new User(null, 40)
        )));
    }*/

}
