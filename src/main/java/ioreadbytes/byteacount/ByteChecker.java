package ioreadbytes.byteacount;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {
    public int readBytesAndFindAs(String fileName) {
        Path file = Path.of("src/test/resources/ioreadbytes/" + fileName);
        int result = 0;
        try (InputStream inputStream = Files.newInputStream(file)) {
            byte[] buffer = new byte[1000];
            int size;
            while ((size = inputStream.read(buffer)) > 0) {
                for (int i = 0; i < size; i++) {
                    if (buffer[i] == (byte) 'a') {
                        result++;
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }
}
