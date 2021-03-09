package week08.d03S;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> shortestWords(List<String> words) {
        List<String> result = new ArrayList<>();
        int length = getLength(words);
        for (String word : words) {
            if (word.length() == length) {
                result.add(word);
            }
        }
        return result;
    }

    private int getLength(List<String> words) {
        int length = words.get(0).length();
        for (String word : words) {
            if (word.length() < length) {
                length = word.length();
            }
        }
        return length;
    }

}
