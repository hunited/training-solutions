package week06d03;

public class WordEraser {

    public String eraseWord(String words, String word) {
        if (words == null || "".equals(words) || word == null || "".equals(word)) {
            throw new NullPointerException("Üres a string!");
        }
        String[] wordList = words.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordList.length; i++) {
            if (!word.equals(wordList[i])) {
                sb.append(wordList[i] + " ");
            }
        }
        return sb.delete(sb.length() - 1, sb.length()).toString();
    }

}
