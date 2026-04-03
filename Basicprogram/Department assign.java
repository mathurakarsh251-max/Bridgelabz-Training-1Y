interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    protected String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("ID: " + employeeId + " | Name: " + name + 
                           " | Dept: " + department + " | Total Salary: $" + calculateSalary());
    }
    public void assignDepartment(String deptName) { this.department = deptName; }
    public String getDepartmentDetails() { return "Department: " + department; }
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
}
class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(int id, String name, double base, double bonus) {
        super(id, name, base);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hours, double rate) {
        super(id, name, 0); 
        this.hoursWorked = hours;
        this.hourlyRate = rate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        FullTimeEmployee ft = new FullTimeEmployee(101, "Alice", 5000, 1200);
        ft.assignDepartment("Engineering");

        PartTimeEmployee pt = new PartTimeEmployee(102, "Bob", 80, 25);
        pt.assignDepartment("Design");
        employees.add(ft);
        employees.add(pt);
        System.out.println("--- Employee Management System ---");
        for (Employee emp : employees) {
            emp.displayDetails(); 
        }
    }
}