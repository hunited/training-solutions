package week06.d01S;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SeparatedSum {

    public ResultPosNeg sum(String s) {
        //public String sum(String s) {
        if (s == null) {
            throw new NullPointerException("A lista null!");
        }
        Scanner scanner = new Scanner(s.replace(',', '.')).useDelimiter(";");
        List<Double> input = new ArrayList<>();
        scanner.useLocale(new Locale("en", "US"));
        while (scanner.hasNext()) {
            input.add(scanner.nextDouble());
        }
        double positive = 0.0;
        double negative = 0.0;
        for (Double output : input) {
            if (output < 0.0) {
                negative += output;
            } else if (output > 0.0) {
                positive += output;
            }
        }
        return new ResultPosNeg(negative, positive);
        //return String.format("%,.2f;%,.2f", negative, positive);
    }

}
