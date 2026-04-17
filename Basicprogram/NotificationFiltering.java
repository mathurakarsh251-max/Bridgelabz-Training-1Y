import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class PatientAlert {
    String patientName;
    String type; 
    int severity; 
    String message;

    public PatientAlert(String patientName, String type, int severity, String message) {
        this.patientName = patientName;
        this.type = type;
        this.severity = severity;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("[%s] Severity %d | %s: %s", 
                             patientName, severity, type, message);
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<PatientAlert> alerts = Arrays.asList(
            new PatientAlert("John Doe", "Heart Rate", 5, "Tachycardia detected!"),
            new PatientAlert("Jane Smith", "Temperature", 2, "Mild fever."),
            new PatientAlert("Bob Brown", "Blood Pressure", 4, "Hypertensive crisis."),
            new PatientAlert("Alice White", "Heart Rate", 1, "Slightly elevated pulse."),
            new PatientAlert("Eve Black", "Oxygen Level", 5, "Low SpO2!")
        );
        Predicate<PatientAlert> isCritical = a -> a.severity >= 4;
        Predicate<PatientAlert> isHeartRelated = a -> a.type.equals("Heart Rate");
        Predicate<PatientAlert> criticalHeartAlert = isCritical.and(isHeartRelated);

        System.out.println("--- CRITICAL ALERTS ---");
        filterAndPrint(alerts, isCritical);

        System.out.println("\n--- HEART RELATED ALERTS ---");
        filterAndPrint(alerts, isHeartRelated);

        System.out.println("\n--- CRITICAL HEART ALERTS ONLY ---");
        filterAndPrint(alerts, criticalHeartAlert);
    }
    public static void filterAndPrint(List<PatientAlert> list, Predicate<PatientAlert> condition) {
        list.stream()
            .filter(condition)
            .forEach(System.out::println);
    }
}