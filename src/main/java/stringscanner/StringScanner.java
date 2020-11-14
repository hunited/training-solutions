package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intString, String delimiter) {
        try (Scanner scanner = new Scanner(intString)) {
            if (!isEmpty(delimiter)) {
                scanner.useDelimiter(delimiter);
            }
            return calculateWithScanner(scanner);
        }
    }

    private int calculateWithScanner(Scanner scanner) {
        int i = 0;
        try {
            while (scanner.hasNext()) {
                i += scanner.nextInt();
            }
        } catch (InputMismatchException ex) {
            throw new IllegalArgumentException("Incorrect parameter string!", ex);
        }
        return i;
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, null);
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || word == null || "".equals(word)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        try (Scanner scanner = new Scanner(text)) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                String i = scanner.nextLine();
                if (i.contains(word)) {
                    sb.append(i);
                    sb.append("\n");
                }
            }
            return sb.toString().trim();
        }
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

}
