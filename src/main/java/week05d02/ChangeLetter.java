package week05d02;

import java.util.Arrays;
import java.util.List;

public class ChangeLetter {

    private final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public String changeVowels(String string) {
        /* Hosszabb, ciklusokba ágyazott megoldás */
        StringBuilder sb = new StringBuilder(string);
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < VOWELS.size(); j++) {
                if (string.toLowerCase().charAt(i) == VOWELS.get(j)) {
                    sb = sb.replace(i, i + 1, "*");
                }
            }
        }
        return sb.toString();

        /* Egyszerűbb változat
        List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for (int i = 0; i < characters.size(); i++) {
            string = string.replaceAll(characters.get(i).toString(), "*");
        }
        return string;
        */
    }

    public static void main(String[] args) {

        ChangeLetter cl = new ChangeLetter();
        String s = cl.changeVowels("Albertirsa");
        System.out.println(s);

    }

}
