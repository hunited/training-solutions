package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> dayTypes = new ArrayList<>();
        Day d = firstDay;
        for (int i = 0; i < numberOfDays; i++) {
            dayTypes.add(d.getDayType());
            d = nextDay(d);
        }
        return dayTypes;
    }

    private Day nextDay(Day d) {
        if (d.ordinal() == Day.values().length - 1) {
            return Day.values()[0];
        } else {
            return Day.values()[d.ordinal() + 1];
        }
    }

}
