package week13.d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

    @Test
    void testTemplateMerger() {
        TemplateMerger tm = new TemplateMerger();
        String asserted = """
                Az alkalmazott neve: John Doe, születési éve: 1980
                Az alkalmazott neve: Jack Doe, születési éve: 1990
                Az alkalmazott neve: Jane Doe, születési éve: 2000""";
        String employees = tm.merge(Path.of("employees.txt"), new ArrayList<>());
        assertEquals(asserted, employees);
    }

}