package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introControl = new IntroControl();

        System.out.println(introControl.subtractTenIfGreaterThanTen(5));
        System.out.println(introControl.subtractTenIfGreaterThanTen(15));
        System.out.println(introControl.subtractTenIfGreaterThanTen(142));

        System.out.println(introControl.describeNumber(0));
        System.out.println(introControl.describeNumber(1));

        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.greetingToJoe("Pisti"));

        System.out.println(introControl.calculateBonus(999900));
        System.out.println(introControl.calculateBonus(1000000));

        System.out.println(introControl.calculateConsumption(500, 5117));
        System.out.println(introControl.calculateConsumption(8999, 4214));

        introControl.printNumbers(6);

        introControl.printNumbersBetween(9, 12);

        introControl.printNumbersBetweenAnyDirection(9, 12);
        introControl.printNumbersBetweenAnyDirection(14, 11);

        introControl.printOddNumbers(6);

    }
}
