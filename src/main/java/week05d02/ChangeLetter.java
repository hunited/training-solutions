package week05d02;

import java.util.Arrays;
import java.util.List;

public class ChangeLetter {

    public String changeVowels(String string) {
        List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < characters.size(); j++) {
                if (string.toLowerCase().indexOf(i) == characters.get(j)) {
                    string.replace(string.charAt(i), '*');
                    System.out.println(i);
                }
            }
        }
        return string;
    }

    public static void main(String[] args) {

        ChangeLetter cl = new ChangeLetter();
        String s = cl.changeVowels("Albertirsa");
        System.out.println(s);
    }

}
