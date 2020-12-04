package defaultconstructor.date;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (!dateChecker(year, month, day)) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;
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

    private boolean dateChecker(int year, int month, int day) {
        if (year < 1900) {
            return false;
        } else if (month > 12 || month < 1) {
            return false;
        } else if (day < 27 || dayChecker(year, month) < day) {
            System.out.println("Rossz nap" + day);
            return false;
        }
        return true;
    }

    private int dayChecker(int year, int month) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            default:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    return 29;
                } else {
                    return 28;
                }
        }
    }

}
