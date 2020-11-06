package finalmodifier;

public class PiMain {

    public static void main(String[] args) {

        CircleCalculator circleCalculator = new CircleCalculator();

        System.out.println("PI értéke: " + CircleCalculator.PI);

        System.out.println("Terület: " + circleCalculator.calculateArea(10));
        System.out.println("Kerület: " + circleCalculator.calculatePerimeter(10));

        CylinderCalculator cylinderCalculator = new CylinderCalculator();

        System.out.println("Térfogat: " + cylinderCalculator.calculateVolume(10, 15));
        System.out.println("Felszín: " + cylinderCalculator.calculateSurfaceArea(10, 15));
    }

}
