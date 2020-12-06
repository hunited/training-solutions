package introinheritance.employee;

public class Boss extends Employee {

    private static final double LEADERSHIP_FACTOR = 0.1;
    private int numberOfEmployees;

    public Boss(String name, String address, double salary, int numberOfEmployees) {
        super(name, address, salary);
        this.numberOfEmployees = numberOfEmployees;
    }

    public static double getLeadershipFactor() {
        return LEADERSHIP_FACTOR;
    }

    public double getSalary() {
        return super.getSalary() * (1 + (getNumberOfEmployees() * LEADERSHIP_FACTOR));
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
}
