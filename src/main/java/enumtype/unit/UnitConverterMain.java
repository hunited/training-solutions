package enumtype.unit;

import java.math.BigDecimal;
import java.util.Arrays;

public class UnitConverterMain {

    public static void main(String[] args) {

        UnitConverter unitConverter = new UnitConverter();

        System.out.println(unitConverter.convert(new BigDecimal(1), LengthUnit.INCH, LengthUnit.CENTIMETER));
        System.out.println(unitConverter.convert(new BigDecimal(1), LengthUnit.FOOT, LengthUnit.CENTIMETER));
        System.out.println(unitConverter.convert(new BigDecimal(1), LengthUnit.YARD, LengthUnit.CENTIMETER));
        System.out.println(unitConverter.convert(new BigDecimal(1), LengthUnit.MILLIMETER, LengthUnit.CENTIMETER));
        System.out.println(unitConverter.convert(new BigDecimal(1), LengthUnit.METER, LengthUnit.CENTIMETER));
        System.out.println(unitConverter.convert(new BigDecimal(1), LengthUnit.CENTIMETER, LengthUnit.MILLIMETER));

        System.out.println(Arrays.toString(LengthUnit.values()));
        System.out.println(unitConverter.siUnits());

    }

}
