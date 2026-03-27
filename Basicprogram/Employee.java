class Employee {
    int empId;
    String name;
    static String companyDomain = "nexuscorp.com";
    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }
    public String generateEmail() {
        return name.toLowerCase().replace(" ", "") + "@" + companyDomain;
    }

    public void displayProfile() {
        System.out.println("ID: " + empId + " | Name: " + name);
    }
}

class Manager extends Employee {
    String department;

    public Manager(int empId, String name, String department) {
        super(empId, name);
        this.department = department;
    }
    @Override
    public String generateEmail() {
        String cleanName = name.toLowerCase().replace(" ", "");
        String cleanDept = department.toLowerCase();
        return cleanName + "." + cleanDept + "@" + companyDomain;
    }
}

public class CompanySystem {
    public static void main(String[] args) {
        Employee emp = new Employee(101, "Alice Smith");
        Employee mgr = new Manager(501, "Bob Johnson", "IT");

        System.out.println("--- Employee Profile ---");
        emp.displayProfile();
        System.out.println("Email: " + emp.generateEmail());

        System.out.println("\n--- Manager Profile ---");
        mgr.displayProfile();
        System.out.println("Email: " + mgr.generateEmail());
    }
}