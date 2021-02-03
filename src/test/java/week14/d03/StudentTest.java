package week14.d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student = new Student("Sanyi");

    @BeforeEach
    void setUp() {
        student.addMark("Matek", 2);
        student.addMark("Matek", 4);
        student.addMark("Nyelvtan", 3);
    }

    @Test
    void subjectsTest() {
        assertEquals(2, student.getSubjects().size());
    }

    @Test
    void subjectMathTest() {
        assertEquals(2, student.getSubjects().get("Matek").get(0));
        assertEquals(4, student.getSubjects().get("Matek").get(1));
        assertEquals(2, student.getSubjects().get("Matek").size());
    }

    @Test
    void subjectGramarTest() {
        assertEquals(3, student.getSubjects().get("Nyelvtan").get(0));
        assertEquals(1, student.getSubjects().get("Nyelvtan").size());
    }

}
