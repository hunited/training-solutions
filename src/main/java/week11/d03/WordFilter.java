package week11.d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    public List<String> wordsWithChar(List<String> words, char c) {
        if (words == null || words.isEmpty()) {
            throw new NullPointerException("A lista üres!");
        }
        List<String> results = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).indexOf(c) > -1) {
                results.add(words.get(i));
            }
        }
        return results;
    }

}
