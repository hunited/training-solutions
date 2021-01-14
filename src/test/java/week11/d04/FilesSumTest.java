package week11.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilesSumTest {

    @Test
    void testFilesSum() {
        FilesSum fs = new FilesSum();
        assertEquals(0, fs.sumNumbers());
    }

}