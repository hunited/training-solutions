package ioreader.grades;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private final Student student = new Student("Jack_Doe", Arrays.asList(2, 3, 4, 5));

    @Test
    void getListTest() {
        assertEquals(4, student.getGradeList().size());
        student.getGradeList().add(3);
        assertEquals(4, student.getGradeList().size());
    }

    @Test
    void createStudentTest() {
        assertEquals("Jack_Doe", student.getName());
        assertEquals(5, student.getGradeList().get(3).longValue());
    }

    @Test
    void testAverage() {
        assertEquals(3.5, student.average(), 0.000001);
    }

    @Test
    void testIncreasing() {
        assertTrue(student.isIncreasing());
        Student notIncreasing = new Student("Bad_Student", Arrays.asList(2, 3, 2, 5, 4));
        assertFalse(notIncreasing.isIncreasing());
    }

}
