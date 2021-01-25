package week13.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HungarianCitiesTest {

    HungarianCities hc = new HungarianCities();

    @Test
    void addCities() {
        hc.addCities("iranyitoszamok-varosok-2021.csv");
        assertEquals(3324, hc.getCities().size());
    }

    @Test
    void getCities() {
        hc.addCities("iranyitoszamok-varosok-2021.csv");
        assertEquals("Jánossomorja", hc.getCities().get(2971));
    }

    @Test
    void getCitiesError() {
        assertThrows(IllegalArgumentException.class, () -> hc.getCities());
    }

    @Test
    void longestNameHungarianCity() {
        hc.addCities("iranyitoszamok-varosok-2021.csv");
        assertEquals("Jászfelsőszentgyörgy", hc.longestNameHungarianCity());
    }

    @Test
    void longestNameHungarianCityError() {
        assertThrows(IllegalArgumentException.class, () -> hc.longestNameHungarianCity());
    }

}