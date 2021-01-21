package week12.d04;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SecretTest {

    private final Secret s = new Secret();

    @Test
    void binReader() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String path = "src/main/resources/week12/d04/secret.dat";
        s.binReader(path);
        assertEquals("""
                       _
                      | |
                      | | __ ___   ____ _
                  _   | |/ _` \\ \\ / / _` |
                 | |__| | (_| |\\ V / (_| |
                  \\____/ \\__,_| \\_/ \\__,_|
                """, outputStreamCaptor.toString());
    }

    @Test
    void binReaderError() {
        String path = "src/main/resources/week12/_d04/secret.dat";
        assertThrows(IllegalStateException.class, () -> s.binReader(path));
    }
}