package week05d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    public void testUser() {
        User user = new User("Gasparics", "Sándor", "hunited@gmail.com");
        assertEquals("Gasparics Sándor, e-mail: hunited@gmail.com", user.getFulltName() + ", e-mail: " + user.getEmail());
    }

    @Test
    public void testUserNoAt() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new User("Gasparics", "Sándor", "hunitedgmail.com"));
        assertEquals("Az e-mail cím formátuma hibás!", ex.getMessage());
    }

    @Test
    public void testUserNoDot() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new User("Gasparics", "Sándor", "hunited@gmailcom"));
        assertEquals("Az e-mail cím formátuma hibás!", ex.getMessage());
    }

}
