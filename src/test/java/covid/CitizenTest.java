package covid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitizenTest {

    @Test
    void createCitizen() {
        Citizen citizen = new Citizen("Gasparics Sándor", "2100", 40, "hunited@gmail.com", "123458603");
        assertEquals("Gasparics Sándor", citizen.getFullName());
        assertEquals("2100", citizen.getZipCode());
        assertEquals(40, citizen.getAge());
        assertEquals("hunited@gmail.com", citizen.getEmail());
        assertEquals("123458603", citizen.getSsn());
    }

    @Test
    void createCitizenFailName() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "", "2100", 40, "hunited@gmail.com", "123458603")
        );
    }

    @Test
    void createCitizenFailZip() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "9999", 40, "hunited@gmail.com", "123458603")
        );
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", null, 40, "hunited@gmail.com", "123458603")
        );
    }

    @Test
    void createCitizenFailAge() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "2100", 9, "hunited@gmail.com", "123458603")
        );
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "2100", 151, "hunited@gmail.com", "123458603")
        );
    }

    @Test
    void createCitizenFailEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "2100", 40, "h@n", "123458603")
        );
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "2100", 40, "hunitedgmail.com", "123458603")
        );
    }

    @Test
    void createCitizenFailSsn() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "2100", 40, "hunited@gmail.com", "123458602")
        );
    }

    @Test
    void testEquals() {
        Citizen original = new Citizen("Gasparics Sándor", "2100", 40, "hunited@gmail.com", "123458603");
        Citizen toEqual = new Citizen("Gasparics Sándor", "2100", 40, "hunited@gmail.com", "123458603");
        assertEquals(toEqual, original);
    }

}
