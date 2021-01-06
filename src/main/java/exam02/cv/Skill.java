package exam02.cv;

public class Skill {

    private final String name;

    private final int level;

    Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

}
