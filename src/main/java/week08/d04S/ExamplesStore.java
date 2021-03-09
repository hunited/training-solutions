package week08.d04S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {

    public List<String> getTitlesOfExamples() {
        try (InputStream is = ExamplesStore.class.getResourceAsStream("examples.md");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            List<String> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) {
                    result.add(line.substring(2));
                }
            }
            return result;
        } catch (IOException ioe) {
            throw new IllegalStateException("No file", ioe);
        }
    }

}
