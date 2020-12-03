package methodoverloading;

public class Time {

    private int hours;

    private int minutes;

    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
        this.seconds = time.seconds;
    }

    public boolean isEqual(Time time) {
        return sec() == time.sec();
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        Time t = new Time(hours, minutes, seconds);
        return isEqual(t);
    }

    public boolean isEarlier(Time time) {
        return sec() < time.sec();
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        Time t = new Time(hours, minutes, seconds);
        return isEarlier(t);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    private int sec() {
        return 3600 * hours + 60 * minutes + seconds;
    }

}
