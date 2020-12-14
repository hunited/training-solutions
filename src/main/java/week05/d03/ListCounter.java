package week05.d03;

import java.util.Arrays;
import java.util.List;

public class ListCounter {

    public int listCounter(List<String> lists) {
        int i = 0;
        for (String list : lists) {
            if (list.toLowerCase().charAt(0) == 'a') {
                i++;
                System.out.println("Találat: " + list);
            }
        }
        return i;
    }

    public static void main(String[] args) {

        ListCounter lc = new ListCounter();
        System.out.println("A szókeresőnk összesen "
                + lc.listCounter(Arrays.asList("Alma", "Körte", "Cseresznye", "Autó", "ananász", "almalé"))
                + " darab a/A kezdőbetűs szót talált!"
        );

    }

}
