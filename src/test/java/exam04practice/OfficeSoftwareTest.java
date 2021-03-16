package exam04practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficeSoftwareTest {

    @Test
    void increasePrice() {
        OfficeSoftware os = new OfficeSoftware("MS Word", 100);
        os.increasePrice();
        assertEquals(105, os.getPrice());
    }

}
