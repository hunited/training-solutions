package covid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitizenTest {

    @Test
    void createCitizen() {
        Citizen citizen = new Citizen("Gasparics Sándor", "2100", 40, "hunited@gmail.com", "088641764");
        assertEquals("Gasparics Sándor", citizen.getFullName());
        assertEquals("2100", citizen.getZipCode());
        assertEquals(40, citizen.getAge());
        assertEquals("hunited@gmail.com", citizen.getEmail());
        assertEquals("088641764", citizen.getSsn());
    }

    @Test
    void createCitizenFailName() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "", "2100", 40, "hunited@gmail.com", "088641764")
        );
    }

    @Test
    void createCitizenFailZip() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "9999", 40, "hunited@gmail.com", "088641764")
        );
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", null, 40, "hunited@gmail.com", "088641764")
        );
    }

    @Test
    void createCitizenFailAge() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "2100", 9, "hunited@gmail.com", "088641764")
        );
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "2100", 151, "hunited@gmail.com", "088641764")
        );
    }

    @Test
    void createCitizenFailEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "2100", 40, "h@n", "088641764")
        );
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "2100", 40, "hunitedgmail.com", "088641764")
        );
    }

    @Test
    void createCitizenFailSsn() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Gasparics Sándor", "2100", 40, "hunited@gmail.com", "088641763")
        );
    }

    @Test
    void testEquals() {
        Citizen original = new Citizen("Gasparics Sándor", "2100", 40, "hunited@gmail.com", "088641764");
        Citizen toEqual = new Citizen("Gasparics Sándor", "2100", 40, "hunited@gmail.com", "088641764");
        assertEquals(toEqual, original);
    }

}
