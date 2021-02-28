package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = Config.class)
class CitizenDaoTest {

    @Autowired
    private Flyway flyway;

    @Autowired
    private CitizenDao dao;

    @BeforeEach
    void setUp() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void getSettlementsByZip() {
        assertEquals(List.of("Gödöllő"), dao.getSettlementsByZip("2100"));
    }

    @Test
    void validSsn() {
        assertTrue(dao.validSsn("123456788"));
        assertFalse(dao.validSsn("123456787"));
    }

    @Test
    void uploadCitizensFromFile() {
        assertEquals("Successfully uploaded 1000 citizens (columns: Név;Irányítószám;Életkor;E-mail cím;Taj szám).",
                dao.uploadCitizensFromFile("registered-persons-1000.csv"));
    }

    @Test
    void uploadCitizenToDb() {
        Citizen citizen = new Citizen("Gasparics Sándor", "2100", 40, "hunited@gmail.com", "123458603");
        assertEquals(1, dao.uploadCitizenToDb(citizen));
    }

}
