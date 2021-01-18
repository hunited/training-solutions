package week12.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

    @Test
    void roundGradesTest() {
        GradeRounder gr = new GradeRounder();
        int[] test = gr.roundGrades(new int[]{34, 52, 84, 98, 65, 48, 100});
        assertEquals(34, test[0]);
        assertEquals(52, test[1]);
        assertEquals(85, test[2]);
        assertEquals(100, test[3]);
        assertEquals(65, test[4]);
        assertEquals(50, test[5]);
        assertEquals(100, test[6]);
    }

    @Test
    void roundGradesError() {
        GradeRounder gr = new GradeRounder();
        assertThrows(IllegalArgumentException.class, () -> gr.roundGrades(new int[]{-10}));
        assertThrows(IllegalArgumentException.class, () -> gr.roundGrades(new int[]{101}));
    }
}
