import java.util.*;
import java.util.stream.Collectors;

class Doctor {
    private String name;
    private String specialty;
    private boolean availableOnWeekends;

    public Doctor(String name, String specialty, boolean availableOnWeekends) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekends = availableOnWeekends;
    }

    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public boolean isAvailableOnWeekends() { return availableOnWeekends; }

    @Override
    public String toString() {
        return String.format("%-15s | Specialty: %-15s | Weekend: %s", 
                             name, specialty, availableOnWeekends ? "Yes" : "No");
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> hospitalStaff = Arrays.asList(
            new Doctor("Dr. Smith", "Cardiology", true),
            new Doctor("Dr. Adams", "Pediatrics", false),
            new Doctor("Dr. Bhalla", "Neurology", true),
            new Doctor("Dr. Chen", "Cardiology", false),
            new Doctor("Dr. Miller", "Dermatology", true),
            new Doctor("Dr. Gupta", "Neurology", false),
            new Doctor("Dr. Wilson", "Pediatrics", true)
        );
        List<Doctor> weekendSpecialists = hospitalStaff.stream()
            .filter(Doctor::isAvailableOnWeekends)
            .sorted(Comparator.comparing(Doctor::getSpecialty))
            .collect(Collectors.toList());

        System.out.println("--- Available Weekend Specialists ---");
        if (weekendSpecialists.isEmpty()) {
            System.out.println("No doctors available this weekend.");
        } else {
            weekendSpecialists.forEach(System.out::println);
        }
    }
}