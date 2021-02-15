package week16.d01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CanoeOfficeTest {

    CanoeOffice co = new CanoeOffice();
    CanoeRental cr1 = new CanoeRental("Marco", CanoeType.BLUE, LocalDateTime.now());
    CanoeRental cr2 = new CanoeRental("Giselle", CanoeType.RED, LocalDateTime.now());
    CanoeRental cr3 = new CanoeRental("Franc", CanoeType.GREEN, LocalDateTime.now());
    CanoeRental cr4 = new CanoeRental("Stephen", CanoeType.BLUE, LocalDateTime.now());
    CanoeRental cr5 = new CanoeRental("Joseph", CanoeType.RED, LocalDateTime.now());
    CanoeRental cr6 = new CanoeRental("Ben", CanoeType.GREEN, LocalDateTime.now());

    @BeforeEach
    void setUp() {
        co.addRental(cr1);
        co.addRental(cr2);
        co.addRental(cr3);
        co.addRental(cr4);
        co.addRental(cr5);
        co.addRental(cr6);
    }

    @Test
    void createRental() {
        assertEquals(6, co.getRentals().size());
    }

    @Test
    void findRentalByName() {
        CanoeRental asserted = new CanoeRental("Joseph", CanoeType.BLUE, LocalDateTime.now());
        assertEquals(asserted.getName(), co.findRentalByName("Joseph").getName());
    }

    @Test
    void findRentalByNameNotFound() {
        assertThrows(IllegalArgumentException.class, () -> co.findRentalByName("Bill"));
    }

    @Test
    void closeRentalByName() {
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(90);
        co.closeRentalByName("Joseph", endTime);
        assertNotNull(co.getRentals().get(4).getEndTime());
    }

    @Test
    void closeRentalByNameNotFound() {
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(90);
        assertThrows(IllegalArgumentException.class, () -> co.closeRentalByName("Bill", endTime));
    }

    @Test
    void getRentalPriceByName() {
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(90);
        assertEquals(10000, co.getRentalPriceByName("Joseph", endTime));
        assertEquals(12000, co.getRentalPriceByName("Franc", endTime));
        assertEquals(15000, co.getRentalPriceByName("Marco", endTime));
    }

    @Test
    void getRentalPriceByNameNotFound() {
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(90);
        assertThrows(IllegalArgumentException.class, () -> co.getRentalPriceByName("Bill", endTime));
    }

    @Test
    void listClosedRentals() {
        co.closeRentalByName("Joseph", LocalDateTime.now().plusMinutes(80));
        co.closeRentalByName("Marco", LocalDateTime.now().plusMinutes(60));
        co.closeRentalByName("Giselle", LocalDateTime.now().plusMinutes(90));
        assertEquals("Marco", co.listClosedRentals().get(0).getName());
        assertEquals("Joseph", co.listClosedRentals().get(1).getName());
        assertEquals("Giselle", co.listClosedRentals().get(2).getName());
    }

    @Test
    void listClosedRentalsNotFound() {
        assertThrows(IllegalArgumentException.class, () -> co.listClosedRentals());
    }

    @Test
    void countRentals() {
        Map<CanoeType, Integer> result = co.countRentals();
        assertEquals(2, result.get(CanoeType.BLUE));
        assertEquals(2, result.get(CanoeType.RED));
        assertEquals(2, result.get(CanoeType.GREEN));
    }

}