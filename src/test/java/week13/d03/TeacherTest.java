package week13.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    private final Teacher teacher = new Teacher();

    @Test
    void teacherHour() {
        assertEquals(25, teacher.teacherHour("Bagoly Barbara"));
        assertEquals(24, teacher.teacherHour("Bivaly Biti"));
        assertEquals(25, teacher.teacherHour("Cet Celina"));
    }

    @Test
    void teacherHourError() {
        assertThrows(IllegalArgumentException.class, () -> teacher.teacherHour("Nevem Teve"));
    }

}
