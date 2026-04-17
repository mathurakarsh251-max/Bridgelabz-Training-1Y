import java.util.HashMap;
import java.util.Map;

public class CourseRegistration {
    public static void main(String[] args) {
        Map<String, Integer> courses = new HashMap<>();
        courses.put("CS101", 48);
        courses.put("MATH202", 3);
        courses.put("HIST110", 25);
        courses.put("ENG101", 52);
        courses.put("PHYS301", 4);
        updateRegistration(courses, "CS101", 5);  
        updateRegistration(courses, "MATH202", -5); 
        updateRegistration(courses, "PHYS301", 1);  
        System.out.println("--- Course Registration Status Report ---");
        
        System.out.println("\n[Near Full] (Count >= 50):");
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            if (entry.getValue() >= 50) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " students");
            }
        }

        System.out.println("\n[Under-subscribed] (Count < 5):");
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " students");
            }
        }
    }
    public static void updateRegistration(Map<String, Integer> map, String code, int change) {
        if (!map.containsKey(code)) {
            System.out.println("Course " + code + " not found.");
            return;
        }

        int currentCount = map.get(code);
        int newCount = currentCount + change;
        if (newCount < 0) {
            newCount = 0;
        }

        map.put(code, newCount);
    }
}