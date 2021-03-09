package week08.d01S;

import java.util.ArrayList;
import java.util.List;

public class Sultan {

    private static final int DAYS = 100;
    private final boolean[] prisonCells = new boolean[DAYS];

    public Sultan() {
        for (int i = 0; i < DAYS; i++) {
            prisonCells[i] = false;
        }
    }

    public List<Integer> openedDoors() {
        List<Integer> openedDoors = new ArrayList<>();
        for (int i = 0; i < DAYS; i++) {
            if (getCellOpenStatus(i)) {
                openedDoors.add(i + 1);
            }
        }
        return openedDoors;
    }

    private boolean getCellOpenStatus(int i) {
        for (int j = 0; j < DAYS; j++) {
            if ((j + 1) % (i + 1) == 0) {
                prisonCells[j] = !prisonCells[j];
            }
        }
        return prisonCells[i];
    }

}
