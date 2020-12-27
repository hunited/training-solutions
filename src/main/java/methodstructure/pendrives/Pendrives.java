package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendriveList) {
        Pendrive cheapest = pendriveList.get(0);
        for (Pendrive pendrive : pendriveList) {
            if (cheapest.comparePricePerCapacity(pendrive) == 1) {
                cheapest = pendrive;
            }
        }
        return cheapest;
    }

    public Pendrive cheapest(List<Pendrive> pendriveList) {
        Pendrive cheapest = pendriveList.get(0);
        for (Pendrive pendrive : pendriveList) {
            if (pendrive.cheaperThan(cheapest)) {
                cheapest = pendrive;
            }
        }
        return cheapest;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendriveList, int percent, int capacity) {
        for (Pendrive pendrive : pendriveList) {
            if (pendrive.getCapacity() == capacity) {
                pendrive.risePrice(percent);
            }
        }
    }

}
