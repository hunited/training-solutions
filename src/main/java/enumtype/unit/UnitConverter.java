package enumtype.unit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {

    public static final int DEFAULT_SCALE = 4;

    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target) {
        return length.multiply(new BigDecimal(source.getInMilliMeter()))
                .divide(new BigDecimal(target.getInMilliMeter()), DEFAULT_SCALE, RoundingMode.HALF_UP);
    }

    public List<LengthUnit> siUnits() {
        List<LengthUnit> units = new ArrayList<>();
        for (LengthUnit unit : LengthUnit.values()) {
            if (unit.isSI()) {
                units.add(unit);
            }
        }
        return units;
    }

}
