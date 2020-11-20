package week04;

import java.util.ArrayList;
import java.util.List;

public class CharOperations {

    public List<Integer> getPositionOfChar(String base, String part) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < base.length(); i++) {
            if (base.indexOf(part.toLowerCase()) == i) {
                indexes.add(i);
            }
        }
        return indexes;
    }

}
