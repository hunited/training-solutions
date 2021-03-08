package week07.d03S;

public class Date {

    private final int year;
    private final int month;
    private final int day;

    public Date(int year, int month, int day) {
        if (year < 1900 || year > 2500 || month < 1 || month > 12 || day < 1 || day > 31) {
            throw new IllegalArgumentException("Non valid parameter");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static Date of(int year, int month, int day) {
        return new Date(year, month, day);
    }

    public Date withYear(int year) {
        return new Date(year, this.month, this.day);
    }

    public Date withMonth(int month) {
        return new Date(this.year, month, this.day);
    }

    public Date withDay(int day) {
        return new Date(this.year, this.month, day);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

}
