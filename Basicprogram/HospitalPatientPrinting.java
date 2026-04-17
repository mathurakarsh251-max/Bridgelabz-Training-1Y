import java.util.Arrays;
import java.util.List;

public class HospitalPatientPrinting {
    public static void main(String[] args) {
        List<String> patientIDs = Arrays.asList(
            "PID-4501", 
            "PID-8823", 
            "PID-1092", 
            "PID-7764", 
            "PID-3309"
        );

        System.out.println("--- Admin Verification: Patient ID List ---");
        patientIDs.forEach(System.out::println);
        
        System.out.println("\n--- Verification Complete ---");
    }
}