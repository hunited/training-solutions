package week13.d02;

import java.time.LocalTime;

public class Fly {
    private final String name;
    private final String type;
    private final String target;
    private final LocalTime time;

    public Fly(String name, String type, String target, LocalTime time) {
        this.name = name;
        this.type = type;
        this.target = target;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getTarget() {
        return target;
    }

    public LocalTime getTime() {
        return time;
    }

}
