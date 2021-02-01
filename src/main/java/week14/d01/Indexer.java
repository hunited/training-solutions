package week14.d01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        for (String name : names) {
            char letter = name.charAt(0);
            if (!result.containsKey(letter)) {
                result.put(letter, new ArrayList<>());
            }
            result.get(letter).add(name);
        }
        return result;
    }

}
