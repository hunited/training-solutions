package week13.d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

    TemplateMerger tm = new TemplateMerger();
    Employee e1 = new Employee("John Doe", 1980);
    Employee e2 = new Employee("Jack Doe", 1990);
    Employee e3 = new Employee("Jane Doe", 2000);
    String file = "src/main/resources/week13/d04/template-merger.txt";

    @Test
    void testTemplateMerger() {
        String asserted = """
                Az alkalmazott neve: John Doe, születési éve: 1980
                Az alkalmazott neve: Jack Doe, születési éve: 1990
                Az alkalmazott neve: Jane Doe, születési éve: 2000
                """;
        String employees = tm.merge(Path.of(file), List.of(e1, e2, e3));
        assertEquals(asserted, employees);
    }

}