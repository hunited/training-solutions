package exceptions.faults;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FaultList {

    public List<String> processLines(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("lines is null");
        }
        List<String> faults = new ArrayList<>();
        for (String line : lines) {
            String[] words = line.split(",");
            int lineNumber = readLineNumber(words[0]);
            if (lineNumber != -1) {
                ProcessingResult result = processLine(words);
                if (result != ProcessingResult.NO_ERROR) {
                    faults.add(faultLine(lineNumber, result.getCode()));
                }
            }
        }
        return faults;
    }

    private String faultLine(int lineNumber, int code) {
        return lineNumber + "," + code;
    }

    private int readLineNumber(String word) {
        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException npe) {
            return -1;
        }
    }

    private ProcessingResult processLine(String[] words) {
        if (words.length != 3) {
            return ProcessingResult.WORD_COUNT_ERROR;
        }
        boolean valueIsValid = isValueValid(words[1]);
        boolean dateIsValid = isDateValid(words[2]);
        if (!valueIsValid && !dateIsValid) {
            return ProcessingResult.VALUE_AND_DATE_ERROR;
        } else if (!dateIsValid) {
            return ProcessingResult.DATE_ERROR;
        } else if (!valueIsValid) {
            return ProcessingResult.VALUE_ERROR;
        }
        return ProcessingResult.NO_ERROR;
    }

    private boolean isValueValid(String word) {
        try {
            Double.parseDouble(word);
            return true;
        } catch (NumberFormatException npe) {
            return false;
        }
    }

    private boolean isDateValid(String word) {
        try {
            new SimpleDateFormat("yyyy.MM.dd.").parse(word);
            return true;
        } catch (ParseException pe) {
            return false;
        }
    }

}
