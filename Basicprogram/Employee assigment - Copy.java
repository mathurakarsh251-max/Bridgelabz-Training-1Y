class Employee {
    String name;
    int id;
    double salary;
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    void displayDetails() {
        System.out.println("----- Employee Record -----");
        System.out.println("ID:      " + id);
        System.out.println("Name:    " + name);
        System.out.println("Salary:  $" + salary);
        System.out.println("---------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Arjun Singh", 101, 55000.00);
        emp1.displayDetails();
    }
}