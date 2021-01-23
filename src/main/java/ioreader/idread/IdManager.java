package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

    private final List<String> ids = new ArrayList<>();

    public void readIdsFromFile(String filename) {
        Path file = Path.of("src/main/resources/" + filename);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String content;
            while ((content = reader.readLine()) != null) {
                ids.add(content);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public List<String> getIds() {
        return new ArrayList<>(ids);
    }

}
