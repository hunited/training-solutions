package week16.d01;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CanoeRentalTest {

    CanoeRental cr = new CanoeRental("Joseph", CanoeType.BLUE, LocalDateTime.now());

    @Test
    void testSetEndTime() {
        cr.setEndTime(LocalDateTime.now().plusHours(1));
        assertTrue(cr.getEndTime() != null);
    }

    @Test
    void testCalculateRentalSum() {
        cr.setEndTime(LocalDateTime.now().plusMinutes(119));
        assertEquals(2, cr.calculateRentalSum());
    }

}
