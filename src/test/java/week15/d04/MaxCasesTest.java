package week15.d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxCasesTest {

    MaxCases maxCases = new MaxCases();

    @Test
    void findTopThreeWeekTest() {
        List<Case> result = maxCases.findTopXWeek("data.csv", 3);
        assertEquals("2020-48", result.get(0).getYearAndWeek());
        assertEquals("2020-49", result.get(1).getYearAndWeek());
        assertEquals("2020-46", result.get(2).getYearAndWeek());
    }

    @Test
    void findTopFourWeekTest() {
        List<Case> result = maxCases.findTopXWeek("data.csv", 4);
        assertEquals("2020-48", result.get(0).getYearAndWeek());
        assertEquals("2020-49", result.get(1).getYearAndWeek());
        assertEquals("2020-46", result.get(2).getYearAndWeek());
        assertEquals("2020-45", result.get(3).getYearAndWeek());
    }

}