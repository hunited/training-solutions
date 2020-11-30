package week06d01S;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeparatedSum {

    //public ResultPosNeg sum(String s) {
    public String sum(String s) {
        if (s == null) {
            throw new NullPointerException("A lista null!");
        }
        Scanner scanner = new Scanner(s.replace(',', '.')).useDelimiter(";");
        List<Double> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(Double.parseDouble(scanner.next()));
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
        //return new ResultPosNeg(negative, positive);
        return String.format("%,.2f;%,.2f", negative, positive);
    }

    public static void main(String[] args) {
        SeparatedSum ss = new SeparatedSum();
        System.out.println(ss.sum("1,2;-2,4;3,6;-4,8;6,0;-7,2;8,4"));
    }

}
