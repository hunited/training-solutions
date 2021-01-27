package ioreaderclasspath.countries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryTest {

    private final Country c = new Country("Hungary", 7);

    @Test
    void createCountryTest() {
        assertEquals("Hungary", c.getName());
        assertEquals(7, c.getBorderCountries());
    }

}
