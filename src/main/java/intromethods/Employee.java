package intromethods;

public class Employee {

    private String name;

    private int hiringYear;

    private int sallary;

    public Employee(String name, int hiringYear, int sallary) {
        this.name = name;
        this.hiringYear = hiringYear;
        this.sallary = sallary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", hiringYear=" + hiringYear +
                ", sallary=" + sallary +
                '}';
    }

    public void raiseSalary(int up) {
        this.sallary += up;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHiringYear() {
        return hiringYear;
    }

    public int getSallary() {
        return sallary;
    }

}
