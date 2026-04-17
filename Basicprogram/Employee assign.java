class Employee {
    public int employeeID;
    protected String department;
    private double salary;
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public void updateSalary(double incrementPercentage) {
        if (incrementPercentage > 0) {
            this.salary += (this.salary * incrementPercentage / 100);
            System.out.println("Salary updated successfully for ID: " + employeeID);
        } else {
            System.out.println("Invalid increment value.");
        }
    }
}
class Manager extends Employee {
    int teamSize;

    public Manager(int employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary); 
        this.teamSize = teamSize;
    }

    public void displayManagerDetails() {
        System.out.println("======= MANAGER PROFILE =======");
        System.out.println("Employee ID: " + employeeID); 
        System.out.println("Department:  " + department); 
        System.out.println("Current Pay: ₹" + getSalary());
        
        System.out.println("Team Size:   " + teamSize + " members");
        System.out.println("===============================");
    }
}

public class Main {
    public static void main(String[] args) {
        Manager mgr = new Manager(1001, "Engineering", 95000.0, 12);
        mgr.employeeID = 1002; 
        mgr.updateSalary(10.0); 
        mgr.displayManagerDetails();
    }
}