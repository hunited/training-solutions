package week13.d05;

import java.util.HashSet;
import java.util.Set;

public class Letters {

    public int letterCounter(String word) {
        hasEmpty(word);
        Set<Character> characters = new HashSet();
        for (int i = 0; i < word.length(); i++) {
            char c = word.toLowerCase().charAt(i);
            if (c >= 'a' && c <= 'z') {
                characters.add(c);
            }
        }
        return characters.size();
    }

    private void hasEmpty(String word) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("Empty string");
        }
    }

}
