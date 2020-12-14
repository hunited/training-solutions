package week08.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    public void testPosition() {
        Position position = new Position(0, 0);
        Robot robot = new Robot();
        robot.dirrection(position, "FFLLLLLBBBBJJJJJJJ");
        assertEquals(3, position.getX());
        assertEquals(-3, position.getY());
    }

    @Test
    public void testPositionError() {
        Position position = new Position(0, 0);
        Robot robot = new Robot();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> robot.dirrection(position, "FFLALLLBBBBJJJJJJJ"));
        assertEquals("Hibás utasítás!", ex.getMessage());
    }

}