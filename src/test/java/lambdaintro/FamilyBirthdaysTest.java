package lambdaintro;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FamilyBirthdaysTest {

    @Test
    void testIsFamilyBirthday() {
        FamilyBirthdays familyBirthdays = new FamilyBirthdays(
                LocalDate.of(2000, 5, 5),
                LocalDate.of(2010, 10, 20),
                LocalDate.of(1980, 6, 15)
        );
        assertFalse(LocalDate.of(2017, 5, 4).query(familyBirthdays::isFamilyBirthday));
        assertTrue(LocalDate.of(2017, 5, 5).query(familyBirthdays::isFamilyBirthday));
        assertTrue(LocalDate.of(2017, 6, 15).query(familyBirthdays::isFamilyBirthday));
    }

    @Test
    void testNextFamilyBirthDay() {
        FamilyBirthdays familyBirthdays = new FamilyBirthdays(
                LocalDate.of(2000, 5, 5),
                LocalDate.of(2010, 10, 20),
                LocalDate.of(1980, 6, 15)
        );
        assertEquals(1, LocalDate.of(2017, 5, 4).query(familyBirthdays::nextFamilyBirthDay));
        assertEquals(5, LocalDate.of(2017, 6, 10).query(familyBirthdays::nextFamilyBirthDay));
        assertEquals(0, LocalDate.of(2017, 10, 20).query(familyBirthdays::nextFamilyBirthDay));
        assertEquals(176, LocalDate.of(2017, 11, 10).query(familyBirthdays::nextFamilyBirthDay));
    }

}
