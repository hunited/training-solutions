package week05.d03S;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserValidatorTest {

    @Test
    public void testUser() {
        UserValidator uv = new UserValidator();
        String user = uv.validate(Arrays.asList(new User("Gasparics Sándor", 40)));
        assertEquals("Minden rendben volt, a felhasználó (Név: Gasparics Sándor, kor: 40 éves.) adatai megfelelőek!", user);
    }

    @Test
    public void testUserNegAge() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            UserValidator uv = new UserValidator();
            uv.validate(Arrays.asList(new User("Gasparics Sándor", -5)));
        });
    }

    @Test
    public void testUserToOld() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            UserValidator uv = new UserValidator();
            uv.validate(Arrays.asList(new User("Gasparics Sándor", 121)));
        });
    }

    @Test
    public void testUserNoName() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            UserValidator uv = new UserValidator();
            uv.validate(Arrays.asList(
                    new User("", 40),
                    new User(null, 40)
            ));
        });
    }
}
