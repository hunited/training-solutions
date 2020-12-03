package methodchain.robot;

import java.util.List;

public class NavigationPoint {

    private int dist;
    private int azim;

    public NavigationPoint(int dist, int azim) {
        this.dist = dist;
        this.azim = azim;
    }

    public int getDist() {
        return dist;
    }

    public int getAzim() {
        return azim;
    }

    @Override
    public String toString() {
        return "distance: " + dist + " azimut: " + azim;
    }
}
