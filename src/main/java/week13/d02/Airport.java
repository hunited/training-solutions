package week13.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    static final String  MSG = "Fly not found!";
    static final String  DEP = "Departure";
    private final List<Fly> flies = new ArrayList<>();

    public void readFromFile(String fileName) {
        try (InputStream is = Airport.class.getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split(" ");
                String[] time = lineSplit[3].split(":");
                LocalTime localTime = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
                flies.add(new Fly(lineSplit[0], lineSplit[1], lineSplit[2], localTime));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException(MSG, ioe);
        }
    }

    public String typeFinder() {
        int arrival = 0;
        int departure = 0;
        for (Fly fly : flies) {
            if (fly.getType().equals(DEP)) {
                departure++;
            } else {
                arrival++;
            }
        }
        if (arrival == departure) {
            return "Equals";
        }
        return arrival > departure ? "Arrival" : DEP;
    }

    public Fly flyFinder(String keyword) {
        for (Fly fly : flies) {
            if (fly.getName().equals(keyword)) {
                return fly;
            }
        }
        throw new IllegalArgumentException(MSG);
    }

    public List<Fly> flyFinderByCityAndType(String city, String type) {
        List<Fly> flights = new ArrayList<>();
        for (Fly fly : flies) {
            if (fly.getTarget().equals(city) && fly.getType().equals(type)) {
                flights.add(fly);
            }
        }
        if (!flights.isEmpty()) {
            return flights;
        }
        throw new IllegalArgumentException(MSG);
    }

    public Fly earlierFly() {
        Fly result = null;
        for (int i = 1; i < flies.size(); i++) {
            if (flies.get(i).getTime().isBefore(flies.get(i - 1).getTime()) && flies.get(i).getType().equals(DEP)) {
                result = flies.get(i);
            }
        }
        if (result != null) {
            return result;
        }
        throw new IllegalArgumentException(MSG);
    }

    public List<Fly> getFlies() {
        return new ArrayList<>(flies);
    }

}
