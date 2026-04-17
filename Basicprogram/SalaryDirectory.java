import java.util.*;

public class SalaryDirectory {
    public static void main(String[] args) {
        Map<String, Double> employeeSalaries = new HashMap<>();
        employeeSalaries.put("Alice", 75000.0);
        employeeSalaries.put("Bob", 62000.0);
        employeeSalaries.put("Charlie", 95000.0);
        employeeSalaries.put("Diana", 82000.0);
        employeeSalaries.put("Ethan", 58000.0);
        employeeSalaries.put("Fiona", 95000.0); 
        giveRaise(employeeSalaries, "Bob", 10);
        giveRaise(employeeSalaries, "Alice", 5);
        giveRaise(employeeSalaries, "Zane", 5); 
        printAverageSalary(employeeSalaries);
        printHighestPaid(employeeSalaries);
    }
    public static void giveRaise(Map<String, Double> map, String name, double percentage) {
        if (map.containsKey(name)) {
            double currentSalary = map.get(name);
            double newSalary = currentSalary * (1 + (percentage / 100));
            map.put(name, newSalary);
            System.out.printf("Raise applied! %s's new salary: $%.2f%n", name, newSalary);
        } else {
            System.out.println("Employee " + name + " not found.");
        }
    }
    public static void printAverageSalary(Map<String, Double> map) {
        if (map.isEmpty()) return;
        
        double total = 0;
        for (double salary : map.values()) {
            total += salary;
        }
        double avg = total / map.size();
        System.out.printf("%nAverage Company Salary: $%.2f%n", avg);
    }
    public static void printHighestPaid(Map<String, Double> map) {
        if (map.isEmpty()) return;

        double maxSalary = Collections.max(map.values());
        List<String> topEarners = new ArrayList<>();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() == maxSalary) {
                topEarners.add(entry.getKey());
            }
        }

        System.out.println("Highest-paid employee(s): " + topEarners + " ($" + maxSalary + ")");
    }
}