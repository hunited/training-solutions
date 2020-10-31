package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance = new Distance(40.44,true);

        System.out.println("A távolság: " + distance.getDistanceInKm() + " méter. Ez az adat " + (distance.isExact() ? "pontos." : "Nem pontos."));

        int wholeNumber = (int) distance.getDistanceInKm();

        System.out.println(wholeNumber);
    }
}
