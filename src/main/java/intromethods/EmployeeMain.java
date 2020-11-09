package intromethods;

public class EmployeeMain {

    public static void main(String[] args) {

        Employee employee = new Employee("Gipsz Jakab", 2016, 450000);

        System.out.println(employee);

        employee.raiseSalary(50000);

        System.out.println(employee);

        employee.setName("Egy Másik Jakab");

        System.out.println(employee);

        System.out.println(employee.getName());
        System.out.println(employee.getHiringYear());
        System.out.println(employee.getSallary());

    }

}
