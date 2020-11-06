package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {

    List<String > colors = new ArrayList<>();

   public void addLast(String color) {
       colors.add(color);
    }

    public void addFirst(String color) {
       colors.add(0, color);
    }

    public void removeFirst() {
       colors.remove(0);
    }

    public void removeLast() {
       colors.remove(colors.size() - 1);
    }

    public List<String> getColors() {
       return colors;
    }

    public static void main(String[] args) {

       Capsules capsules = new Capsules();

       capsules.addFirst("Piros");
       capsules.addFirst("Sárga");
       capsules.addFirst("Fekete");
       capsules.addFirst("Zöld");
       capsules.addLast("Arany");
       capsules.addLast("Arany Pöttyös");
       capsules.removeFirst();
       capsules.removeLast();

       System.out.println(capsules.getColors());

    }

}
