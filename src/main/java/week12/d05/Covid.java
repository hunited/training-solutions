package week12.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Covid {

    public int covidFinder(String file, String term) {
        int result = 0;
        try (InputStream is = Covid.class.getResourceAsStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result = line.toLowerCase().contains(term.toLowerCase()) ? result + 1 : result;
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
        return result;
    }

}
