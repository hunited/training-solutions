package covid;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CovidFileManagerTest {

    private CovidFileManager cfm = new CovidFileManager();

    @Test
    void uploadCitizensFromFile() {
        assertEquals("Sikeresen feltöltve 1000 páciens (oszlopok: Név;Irányítószám;Életkor;E-mail cím;Taj szám).",
                cfm.uploadCitizensFromFile("registered-persons-1000.csv"));
    }

    @Test
    void saveListToFile() {
        cfm.saveListToFile("9985", "9985.csv");
        assertTrue(Files.exists(Path.of("src/main/resources/covid/9985.csv")));
    }

}
