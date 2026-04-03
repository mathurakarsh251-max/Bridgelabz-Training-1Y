package com.company.hr;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public void displayDetails() {
        System.out.println("ID: " + id + " | Name: " + name + " | Dept: " + department + " | Salary: ₹" + salary);
    }
}
package com.company.payroll;
import com.company.hr.Employee;

public class Payroll {
    public void calculateBonus(Employee e) 
        double currentSalary = e.getSalary();
        double bonus = currentSalary * 0.10;
        e.setSalary(currentSalary + bonus);
        
        System.out.println("Success: 10% Bonus (₹" + bonus + ") applied to " + e.getName());
    }
}
package com.company.main;
import com.company.hr.Employee;          
import com.company.payroll.*;           

public class MainApp {
    public static void main(String[] args) {
        Employee emp = new Employee(101, "Akarsh", "CSE", 50000.0);

        System.out.println("--- Initial Employee Details ---");
        emp.displayDetails();
        Payroll payrollSystem = new Payroll();
        payrollSystem.calculateBonus(emp);

        System.out.println("\n--- Updated Employee Details (Post-Bonus) ---");
        emp.displayDetails();
    }
}