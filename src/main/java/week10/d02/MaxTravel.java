package week10.d02;

import java.util.List;

public class MaxTravel {

    public int getMaxIndex(List<Integer> passengers) {
        if (passengers == null || passengers.isEmpty()) {
            throw new NullPointerException("Nincs utas!");
        }
        int[] stops = getStops(passengers);
        return getMaxPassenger(stops);
    }

    private int[] getStops(List<Integer> passengers) {
        int[] stops = new int[30];
        for (int i : passengers) {
            if (i >= 30) {
                throw new ArrayIndexOutOfBoundsException("Csak 30 megálló lehet!");
            }
            stops[i]++;
        }
        return stops;
    }

    private int getMaxPassenger(int[] stops) {
        int passenger = 0;
        for (int i = 0; i < stops.length; i++) {
            if (stops[passenger] < stops[i]) {
                passenger = i;
            }
        }
        return passenger;
    }

}
