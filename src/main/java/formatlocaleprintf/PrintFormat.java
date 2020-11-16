package formatlocaleprintf;

import java.util.Locale;
import java.util.MissingFormatArgumentException;

public class PrintFormat {

    public String formatMessageWithIntegerParameters(String formatString, Integer i, Integer j) {
        try {
            return String.format(new Locale("hu", "hu"), formatString, i, j);
        } catch (MissingFormatArgumentException ex) {
            throw new IllegalArgumentException("Less objects then expected in format String!", ex);
        }
    }

    public String printFormattedText(Double number) {
        return String.format(new Locale("hu", "HU"), "Total is: %,.2f Ft", number);
    }

    public String printFormattedText(int count, String fruit) {
        return String.format(new Locale("hu", "hu"), "We counted %d %s in the basket", count, fruit);
    }

    public String printFormattedText(int number) {
        return String.format(new Locale("hu", "hu"), "Right edge of numbers set at 4 spaces from text:%4d", number);
    }

    public String printFormattedText(Integer i, Integer j, Integer k) {
        return String.format(new Locale("hu", "hu"), "Multiple objects containing text:%d\t%d\t%d", i, j, k);
    }

}
