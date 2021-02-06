package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {
    public Map<String, List<Entry>> parseLog(String log) {
        Map<String, List<Entry>> result = new HashMap<>();
        Scanner scanner = new Scanner(log);
        while (scanner.hasNext()) {
            String[] temp = scanner.nextLine().split(":");
            if (temp.length != 3) {
                throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
            }
            mapGenerator(result, temp);
        }
        scanner.close();
        return result;
    }

    private void mapGenerator(Map<String, List<Entry>> result, String[] temp) {
        if (!result.containsKey(temp[0])) {
            result.put(temp[0], new ArrayList<>());
        }
        result.get(temp[0]).add(new Entry(temp[0], createDate(temp[1]), temp[2]));
    }

    private LocalDate createDate(String date) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException pe) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
    }

}
