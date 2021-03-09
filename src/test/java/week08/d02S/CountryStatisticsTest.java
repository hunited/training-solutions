package week08.d02S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryStatisticsTest {

    @Test
    void createCountries() {
        CountryStatistics cs = new CountryStatistics();
        cs.createCountries("countries.txt");
        assertEquals(11, cs.getCountries().size());
    }

    @Test
    void maxPopulaton() {
        CountryStatistics cs = new CountryStatistics();
        cs.createCountries("countries.txt");
        Country asserted = new Country("Kongoi_Demokratikus_Koztarsasag", 79, 3, 9);
        assertEquals(asserted, cs.maxPopulation());
    }

}
