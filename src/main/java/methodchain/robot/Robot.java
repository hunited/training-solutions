package methodchain.robot;

import week06d02.Product;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private int distance;

    private int azimut;

    private List<NavigationPoint> navigationList = new ArrayList<>();

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public List<NavigationPoint> getNavigationList() {
        return navigationList;
    }

    public Robot go(int i) {
        this.distance += i;
        return this;
    }

    public Robot rotate(int i) {
        this.azimut += i;
        return this;
    }

    public Robot registerNavigationPoint() {
        this.navigationList.add(new NavigationPoint(this.distance, this.azimut));
        return this;
    }

}
