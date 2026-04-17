import java.util.HashMap;
import java.util.Map;

public class AttendanceTracker {
    public static void main(String[] args) {
        Map<String, Integer> attendance = new HashMap<>();
        String[] students = {"Alice", "Bob", "Charlie", "David", "Eve"};
        for (String student : students) {
            attendance.put(student, 0);
        }
        for (int day = 1; day <= 15; day++) {
            String[] presentToday = getSimulatedAttendance(day);

            for (String name : presentToday) {
                if (attendance.containsKey(name)) {
                    attendance.put(name, attendance.get(name) + 1);
                }
            }
        }
        System.out.println("--- Monthly Attendance Report ---");
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " days");
        }
        int threshold = 10;
        System.out.println("\n--- Students attending fewer than " + threshold + " days ---");
        boolean allGood = true;
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            if (entry.getValue() < threshold) {
                System.out.println("Warning: " + entry.getKey() + " (" + entry.getValue() + " days)");
                allGood = false;
            }
        }
        if (allGood) System.out.println("All students met the attendance threshold.");
    }
    public static String[] getSimulatedAttendance(int day) {
        if (day % 3 == 0) return new String[]{"Alice", "Bob", "Eve"};
        if (day % 5 == 0) return new String[]{"Alice", "Bob", "David"};
        return new String[]{"Alice", "Bob", "Charlie", "David", "Eve"};
    }
}