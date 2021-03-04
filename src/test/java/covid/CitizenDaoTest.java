package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = Config.class)
class CitizenDaoTest {

    @Autowired
    private Flyway flyway;

    @Autowired
    private CitizenDao dao;

    private final Citizen citizen = new Citizen(
            "Gasparics Sándor", "2100", 40, "hunited@gmail.com", "123458603"
    );

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
    void uploadCitizenToDb() {
        assertEquals(1, dao.uploadCitizenToDb(citizen));
    }

    @Test
    void hasZipInCitizens() {
        dao.uploadCitizenToDb(citizen);
        assertEquals("2100", dao.hasZipInCitizens(citizen.getZipCode()));
    }

    @Test
    void hasSuitableTajInCitizens() {
        dao.uploadCitizenToDb(citizen);
        assertEquals(1, dao.hasSuitableTajInCitizens(citizen.getSsn()));
    }

    @Test
    void firstVaccinationType() {
        dao.uploadCitizenToDb(citizen);
        int id = dao.hasSuitableTajInCitizens(citizen.getSsn());
        assertNull(dao.firstVaccinationType(id));
    }

    @Test
    void listRowsByZip() {
        dao.uploadCitizenToDb(citizen);
        List<String> result = dao.listRowsByZip(citizen.getZipCode());
        assertEquals("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám", result.get(0));
        assertEquals("08:00;Gasparics Sándor;2100;40;hunited@gmail.com;123458603", result.get(1));
    }

    @Test
    void successfulVaccination() {
        dao.uploadCitizenToDb(citizen);
        int id = dao.hasSuitableTajInCitizens(citizen.getSsn());
        assertEquals(1, dao.successfulVaccination(id, LocalDateTime.now(), VaccinationType.SINOPHARM));
    }

    @Test
    void unsuccessfulVaccination() {
        dao.uploadCitizenToDb(citizen);
        int id = dao.hasSuitableTajInCitizens(citizen.getSsn());
        assertEquals(1, dao.unsuccessfulVaccination(id, LocalDateTime.now(), "Teszt sikertelen"));
    }

    @Test
    void queryZipCodes() {
        dao.uploadCitizenToDb(citizen);
        List<String> asserted = List.of(citizen.getZipCode());
        assertEquals(asserted, dao.queryZipCodes());
    }

    @Test
    void queryNumberOfVaccinations() {
        dao.uploadCitizenToDb(citizen);
        Map<Integer, Integer> asserted = new HashMap<>();
        asserted.put(0, 1);
        assertEquals(asserted, dao.queryNumberOfVaccinations(citizen.getZipCode()));
    }

}
