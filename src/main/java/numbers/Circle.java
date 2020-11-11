package numbers;

public class Circle {

    private int diameter;

    private final double PI = 3.14;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter() {
        return 2 * diameter * PI;
    }

    public double area() {
        return Math.pow(diameter, 2) * PI;
    }

    public int getDiameter() {
        return diameter;
    }

    public double getPI() {
        return PI;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

}
