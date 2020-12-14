package week07.d04;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class LabTest {

    @Test
    public void labTestNotCompleted() {
        assertEquals("A(z) Feladat 1 feladat még nem készült el.", new Lab("Feladat 1").toString());
    }

    @Test
    public void labTestCompleted() {
        assertEquals("A(z) Feladat 1 feladat elkészült ekkor: 12:20.", new Lab("Feladat 1", LocalTime.of(12, 20)).toString());
    }

    @Test
    public void labTestCompletedNow() {
        Lab lab = new Lab("Feladat 1");
        lab.complete();
        assertEquals("A(z) Feladat 1 feladat elkészült ekkor: "
                        + LocalTime.now().getHour()
                        + ":"
                        + LocalTime.now().getMinute()
                        + ".",
                lab.toString());
    }

    @Test
    public void labTestCompletedAt() {
        Lab lab = new Lab("Feladat 1");
        lab.complete(LocalTime.of(12, 20));
        assertEquals("A(z) Feladat 1 feladat elkészült ekkor: 12:20.",lab.toString());
    }

}