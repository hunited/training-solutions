package week12.d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Secret {

    public void binReader(String path) {
        Path file = Path.of(path);
        try {
            byte[] bytes = Files.readAllBytes(file);
            for (byte b : bytes) {
                System.out.print((char) (b + 10));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

}
