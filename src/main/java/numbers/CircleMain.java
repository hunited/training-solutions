package numbers;

import java.util.Scanner;

public class CircleMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg az első kör átmérőjét (cm)!");
        Circle circle1 = new Circle(Integer.parseInt(scanner.nextLine()));
        System.out.println("Az első kör kerülete: " + circle1.perimeter() + " cm, a területe: " + circle1.area() + " cm2");

        System.out.println("Add meg a második kör átmérőjét (cm)!");
        Circle circle2 = new Circle(Integer.parseInt(scanner.nextLine()));
        System.out.println("A második kör kerülete: " + circle2.perimeter() + " cm, a területe: " + circle2.area() + " cm2");

    }

}
