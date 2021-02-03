package week14.d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    public final ClassNotebook cn = new ClassNotebook();

    @BeforeEach
    void setUp() {
        cn.addStudent(new Student("Sanyi"));
        cn.addStudent(new Student("Kati"));
        cn.addStudent(new Student("Zoli"));
    }

    @Test
    void addStudent() {
        cn.addStudent(new Student("Joli"));
        assertEquals(4, cn.getStudents().size());
    }

    @Test
    void studentAddMark() {
        cn.getStudents().get(2).addMark("Matek", 5);
        assertEquals(5, cn.getStudents().get(2).getSubjects().get("Matek").get(0));
    }

    @Test
    void sortNotebook() {
        assertEquals("Kati", cn.sortNotebook().get(0).getName());
    }

}
