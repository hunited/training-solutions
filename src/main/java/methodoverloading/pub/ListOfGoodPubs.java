package methodoverloading.pub;

import java.util.List;

public class ListOfGoodPubs {

    private List<Pub> pubs;

    public ListOfGoodPubs(List<Pub> pubs) {
        if (pubs == null || pubs.size() < 1) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.pubs = pubs;
    }

    public Pub findTheBest() {
        Pub best = pubs.get(0);
        for (Pub pub : pubs) {
            if (pub.getOpenFrom().isEarlier(best.getOpenFrom())) {
                best = pub;
            }
        }
        return best;
    }
}
