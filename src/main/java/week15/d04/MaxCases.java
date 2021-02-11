package week15.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MaxCases {

    public List<Case> findTopXWeek(String fileName, int topX) {
        InputStream is = MaxCases.class.getResourceAsStream(fileName);
        return getTopX(topX, caseCreator(readFile(is)));
    }

    private List<String> readFile(InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            return listOfHungary(br);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private List<String> listOfHungary(BufferedReader br) throws IOException {
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            if (line.contains("Hungary")) {
                lines.add(line);
            }
        }
        return lines;
    }

    private List<Case> caseCreator(List<String> listOfHungary) {
        List<Case> result = new ArrayList<>();
        for (String row : listOfHungary) {
            String[] data = row.split(",");
            result.add(new Case(Integer.parseInt(data[2]), data[1]));
        }
        return result;
    }

    private List<Case> getTopX(int topX, List<Case> allResult) {
        Collections.sort(allResult);
        List<Case> result = new ArrayList<>();
        while (result.size() < topX) {
            result.add(Collections.max(allResult));
            allResult.remove(Collections.max(allResult));
        }
        return result;
    }

}
