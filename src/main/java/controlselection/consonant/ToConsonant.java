package controlselection.consonant;

public class ToConsonant {

    public char convertToConsonant(char character) {
        if ("aeiou".indexOf(character) >= 0) {
            return (char) (character + 1);
        } else {
            return character;
        }
    }

}
