package exceptionclass.course;

public class SimpleTime {

    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        set(hour, minute);
    }

    public SimpleTime(String str) {
        if (str == null) {
            throw new InvalidTimeException("Time is null");
        }
        if (str.length() != 5 || str.charAt(2) != ':') {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        int hour;
        int minute;
        try {
            hour = Integer.parseInt(str.substring(0, 2));
            minute = Integer.parseInt(str.substring(3, 5));
        } catch (NumberFormatException ex) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        set(hour, minute);
    }

    private void set(int hour, int minute) {
        if (hour > 23 || hour < 0) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        this.hour = hour;
        if (minute > 59 || minute < 0) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }

}
