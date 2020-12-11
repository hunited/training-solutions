package week02d05;

import java.util.ArrayList;
import java.util.List;

public class Languages {

    public static void main(String[] args) {

        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Phyton");
        languages.add("JavaScript");

        for (String lang : languages) {
            if (lang.length() > 5) {
                System.out.println(lang);
            }
        }
    }

}
