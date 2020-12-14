package week05.d03S;

import java.util.List;

public class UserValidator {

    public void error(String iaeMessage) {
        throw new IllegalArgumentException(iaeMessage);
    }

    public String validate(List<User> users) {
        String userData = "";
        if (users == null) {
            error("Nincs felhasználó a listában.");
        }
        for (User user : users) {
            if (user.getAge() < 0) {
                error("Hibás adat: a felhasználó életkora 0-nál kisebb!");
            } else if (user.getAge() > 120) {
                error("Hibás adat: a felhasználó életkora 120-nál több!");
            } else if (user.getName() == null || "".equals(user.getName())) {
                error("Hibás adat: a felhasználó neve üres!");
            } else {
                userData = user.toString();
            }
        }
        String text = "Minden rendben volt, a felhasználó (" + userData + ") adatai megfelelőek!";
        return text;

    }

}
