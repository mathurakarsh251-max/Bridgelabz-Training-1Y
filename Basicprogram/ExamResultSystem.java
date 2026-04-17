import java.util.*;

public class ExamResultSystem {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> schoolReport = new HashMap<>();
        addScore(schoolReport, "Mathematics", "Alice", 95);
        addScore(schoolReport, "Mathematics", "Bob", 88);
        addScore(schoolReport, "Physics", "Alice", 92);
        addScore(schoolReport, "Physics", "Charlie", 79);
        addScore(schoolReport, "History", "Bob", 84);
        addScore(schoolReport, "History", "Charlie", 81);
        printReport(schoolReport);
        printHighAchieverSubjects(schoolReport);
    }
    public static void addScore(Map<String, Map<String, Integer>> report, String subject, String student, int marks) {
        report.putIfAbsent(subject, new HashMap<>());
        report.get(subject).put(student, marks);
    }

    public static void printReport(Map<String, Map<String, Integer>> report) {
        System.out.println("--- Subject Performance Report ---");
        
        for (String subject : report.keySet()) {
            Map<String, Integer> studentMap = report.get(subject);
            
            String topper = "";
            int maxScore = -1;
            double total = 0;

            for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
                int score = entry.getValue();
                total += score;

                if (score > maxScore) {
                    maxScore = score;
                    topper = entry.getKey();
                }
            }

            double avg = total / studentMap.size();
            System.out.printf("Subject: %-12s | Topper: %-8s (%d) | Avg: %.2f%n", 
                               subject, topper, maxScore, avg);
        }
    }

    public static void printHighAchieverSubjects(Map<String, Map<String, Integer>> report) {
        System.out.println("\nSubjects with at least one score > 90:");
        for (Map.Entry<String, Map<String, Integer>> entry : report.entrySet()) {
            boolean hasHighScorer = entry.getValue().values().stream().anyMatch(s -> s > 90);
            if (hasHighScorer) {
                System.out.println("- " + entry.getKey());
            }
        }
    }
}