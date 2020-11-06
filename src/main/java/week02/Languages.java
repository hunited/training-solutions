package week02;

import java.util.ArrayList;
import java.util.List;

public class Languages {

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        myList.add("Java");
        myList.add("Phyton");
        myList.add("JavaScript");

        for (String i : myList) {
            if (i.length() > 5) {
                System.out.println(i);
            }
        }
    }

}
