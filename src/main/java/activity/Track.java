package activity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate() {
        emptyListError();
        double maxLon = trackPoints.get(0).getCoordinate().getLongitude();
        double maxLat = trackPoints.get(0).getCoordinate().getLatitude();
        for (TrackPoint trackPoint : trackPoints) {
            double tLon = trackPoint.getCoordinate().getLongitude();
            double tLat = trackPoint.getCoordinate().getLatitude();
            if (tLat > maxLat) {
                maxLat = tLat;
            }
            if (tLon > maxLon) {
                maxLon = tLon;
            }
        }
        return new Coordinate(maxLat, maxLon);
    }

    public Coordinate findMinimumCoordinate() {
        emptyListError();
        double minLon = trackPoints.get(0).getCoordinate().getLongitude();
        double minLat = trackPoints.get(0).getCoordinate().getLatitude();
        for (TrackPoint trackPoint : trackPoints) {
            double tLon = trackPoint.getCoordinate().getLongitude();
            double tLat = trackPoint.getCoordinate().getLatitude();
            if (tLat < minLat) {
                minLat = tLat;
            }
            if (tLon < minLon) {
                minLon = tLon;
            }
        }
        return new Coordinate(minLat, minLon);
    }

    public double getDistance() {
        double result = 0.0;
        for (int i = 1; i < trackPoints.size(); i++) {
            result += trackPoints.get(i).getDistanceFrom(trackPoints.get(i - 1));
        }
        return result;
    }

    public double getFullDecrease() {
        double result = 0.0;
        for (int i = 1; i < trackPoints.size(); i++) {
            if (trackPoints.get(i).getElevation() < trackPoints.get(i - 1).getElevation()) {
                result += trackPoints.get(i - 1).getElevation() - trackPoints.get(i).getElevation();
            }
        }
        return result;
    }

    public double getFullElevation() {
        double result = 0.0;
        for (int i = 1; i < trackPoints.size(); i++) {
            if (trackPoints.get(i).getElevation() > trackPoints.get(i - 1).getElevation()) {
                result += trackPoints.get(i).getElevation() - trackPoints.get(i - 1).getElevation();
            }
        }
        return result;
    }

    public double getRectangleArea() {
        double width = findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude();
        double height = findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude();
        return width * height;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void loadFromGpx(InputStream is) {
        //Fájlbeolvasás, LoadFileTest teszteseteihez
    }

    private void emptyListError() {
        if (trackPoints == null || trackPoints.isEmpty()) {
            throw new NullPointerException("Empty List");
        }
    }

}
