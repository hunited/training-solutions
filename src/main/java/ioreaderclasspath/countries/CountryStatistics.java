package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private final List<Country> countryList = new ArrayList<>();

    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(CountryStatistics.class.getResourceAsStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitter = line.split(" ");
                countryList.add(new Country(splitter[0], Integer.parseInt(splitter[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File notfound", ioe);
        }
    }

    public int numberOFCountries() {
        return countryList.size();
    }

    public Country mostBorderCountries() {
        int max = countryList.get(0).getBorderCountries();
        Country result = countryList.get(0);
        for (Country country : countryList) {
            if (country.getBorderCountries() > max) {
                max = country.getBorderCountries();
                result = country;
            }
        }
        return result;
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

}
