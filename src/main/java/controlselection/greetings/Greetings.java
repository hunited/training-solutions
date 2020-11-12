package controlselection.greetings;

public class Greetings {

    private final int HOURINMIN = 60;

    public void greeter(int hour, int minutes) {

        if (((hour * HOURINMIN + minutes) >= (20 * HOURINMIN)) || ((hour * HOURINMIN + minutes) < (5 * HOURINMIN))) {
            System.out.println("Jó éjt!");
        } else if ((hour * HOURINMIN + minutes) > (18.5 * HOURINMIN)) {
            System.out.println("Jó estét!");
        } else if ((hour * HOURINMIN + minutes) >= (9 * HOURINMIN)) {
            System.out.println("Jó napot!");
        } else {
            System.out.println("Jó reggelt!");
        }
    }

    public static void main(String[] args) {

        Greetings greetings = new Greetings();

        greetings.greeter(4, 59);
        greetings.greeter(5, 0);
        greetings.greeter(8, 59);
        greetings.greeter(9, 0);
        greetings.greeter(18, 30);
        greetings.greeter(18, 31);
        greetings.greeter(19, 59);
        greetings.greeter(20, 0);

    }

}
