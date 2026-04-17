import java.util.*;

public class EmployeeManagement {
    public static void main(String[] args) {
        Map<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(101, "Engineering");
        employeeMap.put(102, "HR");
        employeeMap.put(103, "Engineering");
        employeeMap.put(104, "Marketing");
        employeeMap.put(105, "Engineering");
        employeeMap.put(106, "HR");
        System.out.println("Moving Employee 104 to Engineering...");
        employeeMap.put(104, "Engineering"); 
        findEmployeesInDept(employeeMap, "Engineering");
        printDepartmentStats(employeeMap);
    }
    public static void findEmployeesInDept(Map<Integer, String> map, String dept) {
        List<Integer> ids = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(dept)) {
                ids.add(entry.getKey());
            }
        }
        System.out.println("Employees in " + dept + ": " + ids);
    }
    public static void printDepartmentStats(Map<Integer, String> map) {
        Map<String, Integer> stats = new HashMap<>();

        for (String dept : map.values()) {
            stats.put(dept, stats.getOrDefault(dept, 0) + 1);
        }

        System.out.println("\n--- Department Headcount ---");
        stats.forEach((dept, count) -> 
            System.out.println(dept + ": " + count + " employee(s)")
        );
    }
}