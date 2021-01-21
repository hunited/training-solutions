package methoverloading.pub;

import methoverloading.Time;

public class Pub {

    private String name;

    private Time openFrom;

    public Pub(String name, int hour, int min) {
        this.name = name;
        this.openFrom = new Time(hour, min);
    }

    public String getName() {
        return name;
    }

    public Time getOpenFrom() {
        return openFrom;
    }

    @Override
    public String toString() {
        return name + ";" + openFrom.getHours() + ":" + openFrom.getMinutes();
    }
}
