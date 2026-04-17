import java.util.Map;
import java.util.TreeMap;

public class GradeTracker {
    public static void main(String[] args) {
        Map<String, Double> studentGrades = new TreeMap<>();
        studentGrades.put("Zayn", 85.5);
        studentGrades.put("Alice", 92.0);
        studentGrades.put("Charlie", 78.0);
        studentGrades.put("Bob", 88.5);
        studentGrades.put("Charlie", 95.0);
        studentGrades.remove("Zayn");
        System.out.println("--- Student Grade Report (Alphabetical) ---");
        for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " | Grade: " + entry.getValue());
        }
    }
}