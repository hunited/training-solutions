package introdate;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee("Gasparics Sándor", 1980, 12, 29);
        System.out.println("A munkavállaló neve: " + employee.getName() +
                "\nSzületési dátuma: " + employee.getDateOfBirth() +
                "\nBelépés dátuma: " + employee.getBeginEmployment());
    }
}
