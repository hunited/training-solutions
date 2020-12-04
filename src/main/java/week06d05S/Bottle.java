package week06d05S;

public class Bottle {

    private BottleType type;
    private int filledUnit;

    public Bottle(BottleType type, int filledUnit) {
        this.type = type;
        if (filledUnit < 1) {
            throw new IllegalArgumentException("A mennyiség nem lehet egynél kevesebb!");
        }
        this.filledUnit = filledUnit;
    }

    public static Bottle of(BottleType bottleType) {
        return new Bottle(bottleType, 0);
    }

    public void fill(int fillAmount) {
        this.filledUnit += fillAmount;
        if (filledUnit > this.type.getMaximumAmount()) {
            throw new IllegalArgumentException("Túlcsordult!");
        }
    }

    public BottleType getType() {
        return type;
    }

    public int getFilledUnit() {
        return filledUnit;
    }

}
