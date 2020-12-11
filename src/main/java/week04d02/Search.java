package week04d02;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public List<Integer> getPositionOfChar(String base, String part) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < base.length(); i++) {
            if (part.toLowerCase().charAt(0) == base.toLowerCase().charAt(i)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

}
