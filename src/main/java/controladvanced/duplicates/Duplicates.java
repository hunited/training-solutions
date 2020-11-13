package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {

    public List<Integer> find(List<Integer> find){
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < find.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (find.get(i).equals(find.get(j))) {
                    duplicates.add(find.get(i));
                    break;
                }
            }
        }
        return duplicates;
    }

}
