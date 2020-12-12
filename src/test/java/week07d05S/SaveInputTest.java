package week07d05S;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SaveInputTest {
    @Test
    void testReadLines() {

        SaveInput si = new SaveInput(new Scanner("aaa\nbbb\nccc\na.txt"));
        assertEquals(List.of("aaa", "bbb", "ccc"), si.readLines());
    }

    @Test
    void testReadFile() {

        SaveInput si = new SaveInput(new Scanner("aaa\nbbb\nccc\na.txt"));
        si.readLines();
        assertEquals(Path.of("a.txt"), si.readFileName().getFileName());
    }

    @Test
    void testFileWriter() {
        SaveInput si = new SaveInput(new Scanner("aaa\nbbb\nccc\na.txt"));
        assertTrue(si.fileWriter(si.readLines()));
    }

    @Test
    public void testFileWriterError() {
        SaveInput si = new SaveInput(new Scanner("aaa\nbbb\nccc\n."));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> si.fileWriter(si.readLines()));
        assertEquals("Nem írható a fájl: java.nio.file.AccessDeniedException: .", ex.getMessage());
    }

}