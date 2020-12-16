package week08.d03;

import java.util.ArrayList;
import java.util.List;

public class StringList {

    public List<String> stringListsUnion(List<String> first, List<String> second) {
        checkValid(first, second);
        List<String> result = new ArrayList<>();
        result.addAll(first);
        for (String element : second) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    private void checkValid(List<String> first, List<String> second) {
        if (first == null || second == null || first.isEmpty() || second.isEmpty()) {
            throw new NullPointerException("Egyik lista sem lehet üres");
        }
    }

}
