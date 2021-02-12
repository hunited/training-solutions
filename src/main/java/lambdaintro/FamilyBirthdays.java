package lambdaintro;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {

    private final List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... birthdays) {
        this.birthdays = Arrays.asList(birthdays);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        for (LocalDate birthday : birthdays) {
            if (birthday.get(ChronoField.MONTH_OF_YEAR) == month && birthday.get(ChronoField.DAY_OF_MONTH) == day) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        LocalDate current = LocalDate.of(year, month, day);
        int result = Integer.MAX_VALUE;
        for (LocalDate birthday : birthdays) {
            LocalDate next = birthday.withYear(year);
            if (next.isBefore(current)) {
                next = birthday.withYear(year + 1);
            }
            int temp = (int) ChronoUnit.DAYS.between(current, next);
            if (result > temp) {
                result = temp;
            }
        }
        return result;
    }


}
