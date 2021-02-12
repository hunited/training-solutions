package week15.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameOfThrones {

    public Map.Entry<String, Integer> mostIdiotsHouse(String fileName) {
        Map<String, Integer> idiots = new HashMap<>();
        InputStream is = GameOfThrones.class.getResourceAsStream(fileName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            br.readLine();
            processLine(idiots, br);
            return getMostIdiots(idiots);
        } catch (IOException ioe) {
            throw new IllegalStateException("No file", ioe);
        }
    }

    private void processLine(Map<String, Integer> result, BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            List<String> idiots = List.of(row[5], row[6], row[7], row[8], row[9], row[10], row[11], row[12]);
            for (String idiot : idiots) {
                if (!idiot.isEmpty()) {
                    fillMap(result, idiot);
                }
            }
        }
    }

    private Map.Entry<String, Integer> getMostIdiots(Map<String, Integer> idiots) {
        int value = Collections.max(idiots.values());
        Map.Entry<String, Integer> looser = null;
        for (Map.Entry<String, Integer> entry : idiots.entrySet()) {
            if (entry.getValue().equals(value)) {
                looser = entry;
            }
        }
        return looser;
    }

    private void fillMap(Map<String, Integer> result, String idiot) {
        if (!result.containsKey(idiot)) {
            result.put(idiot, 0);
        }
        result.replace(idiot, result.get(idiot) + 1);
    }

}
