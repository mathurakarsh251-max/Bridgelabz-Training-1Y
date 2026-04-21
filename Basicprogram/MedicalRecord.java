import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}
abstract class Patient implements MedicalRecord {
    private String patientId;
    private String name;
    private int age;
    private List<String> history = new ArrayList<>();
    private String diagnosis;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    public abstract double calculateBill();
    public void getPatientDetails() {
        System.out.println("ID: " + patientId + " | Name: " + name + " | Age: " + age);
    }
    public void addRecord(String record) { this.history.add(record); }
    public List<String> viewRecords() { return new ArrayList<>(history); }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public String getName() { return name; }
}
class InPatient extends Patient {
    private int daysStayed;
    private double dailyRate = 500.00;
    private double treatmentFees;

    public InPatient(String id, String name, int age, int days, double fees) {
        super(id, name, age);
        this.daysStayed = days;
        this.treatmentFees = fees;
    }

    @Override
    public double calculateBill() {
        return (daysStayed * dailyRate) + treatmentFees;
    }
}

class OutPatient extends Patient {
    private double consultationFee = 150.00;
    private double labCharges;

    public OutPatient(String id, String name, int age, double labCharges) {
        super(id, name, age);
        this.labCharges = labCharges;
    }

    @Override
    public double calculateBill() {
        return consultationFee + labCharges;
    }
}
public class HospitalApp {
    public static void main(String[] args) {
        List<Patient> hospitalRegistry = new ArrayList<>();
        InPatient p1 = new InPatient("P101", "Emma Smith", 45, 3, 1200.00);
        p1.setDiagnosis("Pneumonia");
        p1.addRecord("Admitted March 28th");

        OutPatient p2 = new OutPatient("P102", "Mark Reed", 29, 300.00);
        p2.setDiagnosis("Mild Flu");
        p2.addRecord("Follow-up in 1 week");

        hospitalRegistry.add(p1);
        hospitalRegistry.add(p2);

        System.out.println("--- Hospital Billing Report ---");
        for (Patient p : hospitalRegistry) {
            p.getPatientDetails();
            System.out.println(" - Diagnosis: " + p.getDiagnosis());
            System.out.println(" - Records: " + p.viewRecords());
            System.out.println(" - Total Due: $" + p.calculateBill());
            System.out.println("--------------------------------");
        }
    }
}