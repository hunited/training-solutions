package enumtype.unit;

import enumtype.week.DayType;

public enum LengthUnit {

    MILLIMETER(true, 1),
    CENTIMETER(true, 10),
    METER(true, 1000),
    YARD(false, 914.4),
    FOOT(false, 304.8),
    INCH(false, 25.4);

    private final boolean isSI;

    private final double inMilliMeter;

    LengthUnit(boolean isSI, double inMiliMeter) {
        this.isSI = isSI;
        this.inMilliMeter = inMiliMeter;
    }

    public boolean isSI() {
        return isSI;
    }

    public double getInMilliMeter() {
        return inMilliMeter;
    }
}
