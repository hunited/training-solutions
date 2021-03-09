package week08.d02S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private final List<Country> countries = new ArrayList<>();

    public void createCountries(String fileName) {
        try (InputStream is = CountryStatistics.class.getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(" ");
                countries.add(new Country(
                        row[0],
                        Integer.parseInt(row[1]),
                        Integer.parseInt(row[2]),
                        Integer.parseInt(row[3])
                ));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("No file", ioe);
        }
    }

    public Country maxPopulation() {
        Country result = countries.get(0);
        for (Country country : countries) {
            if (country.getPopulation() > result.getPopulation()) {
                result = country;
            }
        }
        return result;
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

}
