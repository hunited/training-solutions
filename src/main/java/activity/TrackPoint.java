package activity;

public class TrackPoint {

    private final Coordinate coordinate;
    private final double elevation;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public double getDistanceFrom(TrackPoint trackPoint) {
        final int R = 6371;
        double lat1 = getCoordinate().getLatitude();
        double lat2 = trackPoint.getCoordinate().getLatitude();
        double lon1 = getCoordinate().getLongitude();
        double lon2 = trackPoint.getCoordinate().getLongitude();
        double latDist = Math.toRadians(lat2 - lat1);
        double lonDist = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDist / 2) * Math.sin(latDist / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDist / 2) * Math.sin(lonDist / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double height = getElevation() - trackPoint.getElevation();
        double distance = Math.pow((R * c * 1000), 2) + Math.pow(height, 2);
        return Math.sqrt(distance);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getElevation() {
        return elevation;
    }

}
