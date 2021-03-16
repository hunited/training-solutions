package exam04practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperSoftwareTest {

    @Test
    void increasePrice() {
        DeveloperSoftware ds = new DeveloperSoftware("Idea", 100);
        ds.increasePrice();
        assertEquals(110, ds.getPrice());
    }

}