import java.util.Objects;

class Patient {
    String patientId;
    String name;
    String condition;

    public Patient(String patientId, String name, String condition) {
        this.patientId = patientId;
        this.name = name;
        this.condition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s", patientId, name, condition);
    }
}
import java.util.*;

public class HospitalManager {
    private Set<Patient> admittedPatients = new HashSet<>();
    private Queue<Patient> treatmentQueue = new LinkedList<>();
    private Stack<Patient> dischargeStack = new Stack<>();
    private List<Patient> masterHistory = new ArrayList<>();
    public void admitPatient(Patient p) {
        if (admittedPatients.add(p)) {
            treatmentQueue.add(p);
            masterHistory.add(p);
            System.out.println("Admitted and Queued: " + p.name);
        } else {
            System.out.println("Patient " + p.name + " is already currently admitted.");
        }
    }
    public void treatPatient() {
        if (!treatmentQueue.isEmpty()) {
            Patient p = treatmentQueue.poll();
            System.out.println("Currently treating: " + p.name);
        } else {
            System.out.println("No patients waiting for treatment.");
        }
    }
    public void dischargePatient(Patient p) {
        if (admittedPatients.remove(p)) {
            dischargeStack.push(p);
            System.out.println("Discharged: " + p.name + ". Moved to recent discharge stack.");
        }
    }
    public void emergencyReadmit() {
        if (!dischargeStack.isEmpty()) {
            Patient p = dischargeStack.pop();
            admittedPatients.add(p);
            treatmentQueue.add(p); 
            System.out.println("Emergency Re-admission: " + p.name + " is back in the queue.");
        } else {
            System.out.println("No recently discharged patients to re-admit.");
        }
    }
}