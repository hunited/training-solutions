package week08.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    Position position = new Position(0, 0);
    Robot robot = new Robot();

    @Test
    public void testPosition() {
        robot.dirrection(position, "FFLLLLLBBBBJJJJJJJ");
        assertEquals(3, position.getX());
        assertEquals(-3, position.getY());
    }

    @Test
    public void testPositionError() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> robot.dirrection(position, "FFLALLLBBBBJJJJJJJ"));
        assertEquals("Hibás utasítás!", ex.getMessage());
    }

}