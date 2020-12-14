package week07.d02S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserImplTest {

    @Test
    public void UserImpl(){
        assertEquals("Sándor Gasparics", new UserImpl("hunited", "Sándor", "Gasparics").getFullName());
    }
}
