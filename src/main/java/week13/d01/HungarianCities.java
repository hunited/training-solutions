package week13.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HungarianCities {

    private final List<String> cities = new ArrayList<>();

    public void addCities(String file) {
        try (InputStream is = HungarianCities.class.getResourceAsStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cityLine = line.split(";");
                if (!cityLine[1].contains("Település")) {
                    cities.add(cityLine[1].trim());
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    public String longestNameHungarianCity() {
        emptyList();
        int longest = cities.get(0).length();
        String longestNameCity = cities.get(0);
        for (String city : cities) {
            if (city.length() > longest) {
                longest = city.length();
                longestNameCity = city;
            }
        }
        return longestNameCity;
    }

    public List<String> getCities() {
        emptyList();
        return new ArrayList<>(cities);
    }

    private void emptyList() {
        if (cities.isEmpty()) {
            throw new IllegalArgumentException("Empty List");
        }
    }

}
