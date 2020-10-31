package statements;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getInMinutes() {
        int hourInMinutes = 60;
        return hours * hourInMinutes + minutes;
    }

    public int getInSeconds() {
        int minuteInSeconds = 60;
        return getInMinutes() * minuteInSeconds + seconds;
    }

    public boolean earlierThan(Time secondTime) {
        int firstTimeSec = this.getInSeconds();
        int secondTimeSec = secondTime.getInSeconds();
        return firstTimeSec < secondTimeSec;
    }

    public String toString(){
        return hours + ":" + minutes + ":" + seconds;
    }
}
