package week08.d05S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Plane {

    public int getLongestOceanTrip() {
        try (InputStream is = Plane.class.getResourceAsStream("map.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            int longest = 0;
            while ((line = br.readLine()) != null) {
                longest = getLongest(line, longest);
            }
            return longest;
        } catch (IOException ioe) {
            throw new IllegalStateException("No file", ioe);
        }
    }

    private int getLongest(String line, int longest) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == '0') {
                count++;
            } else {
                longest = updateLongest(longest, count);
                count = 0;
            }
        }
        return longest;
    }

    private int updateLongest(int longest, int count) {
        if (longest < count) {
            longest = count;
        }
        return longest;
    }

}
